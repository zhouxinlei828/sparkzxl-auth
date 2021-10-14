package com.github.sparkzxl.auth.domain.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.sparkzxl.auth.application.service.SysIAreaService;
import com.github.sparkzxl.auth.domain.model.aggregates.City;
import com.github.sparkzxl.auth.infrastructure.client.AreaClient;
import com.github.sparkzxl.auth.infrastructure.client.result.Area;
import com.github.sparkzxl.auth.infrastructure.client.result.ResponseEntity;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.convert.SysAreaConvert;
import com.github.sparkzxl.auth.infrastructure.entity.SysArea;
import com.github.sparkzxl.auth.infrastructure.mapper.SysAreaMapper;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaQueryDTO;
import com.github.sparkzxl.core.jackson.JsonUtil;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * description: 地区表 服务实现类
 *
 * @author charles.zhou
 * @date 2020-07-28 19:43:36
 */
@Slf4j
@Service
public class SysAreaServiceImpl extends SuperCacheServiceImpl<SysAreaMapper, SysArea> implements SysIAreaService {

    @Autowired
    private AreaClient areaClient;

    @Value("${area.key}")
    private String areaKey;

    /**
     * 标识符
     */
    private static final String NONE = "[]";

    private static final String STREET = "street";

    private static final String PROVINCE = "province";


    @Override
    public List<SysArea> getAreaList(AreaQueryDTO areaQueryDTO) {
        LambdaQueryWrapper<SysArea> areaLambdaQueryWrapper = new LambdaQueryWrapper<SysArea>()
                .eq(StringUtils.isNotEmpty(areaQueryDTO.getCode()), SysArea::getCode, areaQueryDTO.getCode())
                .likeRight(StringUtils.isNotEmpty(areaQueryDTO.getName()), SysArea::getName, areaQueryDTO.getName());
        List<SysArea> sysAreaList = list(areaLambdaQueryWrapper);
        return SysArea.buildTree(sysAreaList);
    }

    @Override
    public boolean importAreaJsonData(MultipartFile multipartFile) {
        try {
            List<City> cities = JsonUtil.parse(multipartFile.getInputStream(), new TypeReference<List<City>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean getActiveArea(Integer subDistrict) {
        Map<String, Object> queryMap = Maps.newHashMap();
        queryMap.put("keywords", "");
        queryMap.put("subdistrict", 1);
        queryMap.put("key", areaKey);
        ResponseEntity responseEntity = areaClient.getAreaList(queryMap);
        List<Area> areaList = responseEntity.getDistricts();
        areaList.forEach(country -> {
            // 获取国家下面的所有省份
            List<Area> provinceList = country.getDistricts();
            // 排序
            provinceList = provinceList.stream().sorted(Comparator.comparing(Area::getCode)).collect(Collectors.toList());
            provinceList.forEach(province -> {
                Map<String, Object> queryCity = Maps.newHashMap();
                queryCity.put("keywords", "");
                queryCity.put("subdistrict", 3);
                queryCity.put("key", areaKey);
                ResponseEntity cityResponse = areaClient.getAreaList(queryCity);
                List<Area> cityList = cityResponse.getDistricts();
                recursion(cityList, province.getCode());
            });
        });
        return true;
    }

    public void recursion(List<Area> parentList, Long parentCode) {
        if (CollectionUtils.isEmpty(parentList)) {
            return;
        }
        // 对街道,乡镇adCode特殊处理
        for (int i = 0; i < parentList.size(); i++) {
            Area area = parentList.get(i);
            if (StrUtil.equals(STREET, area.getLevel())) {
                Long streetId = Long.valueOf(String.valueOf(area.getCode()).concat(String.format("%02d", i + 1)));
                area.setCode(streetId);
            }
        }
        AtomicInteger sortNumbers = new AtomicInteger(0);
        parentList.forEach(child -> {
            // 设置父id
            if (StrUtil.equals(PROVINCE, child.getLevel())) {
                child.setParentCode(0L);
            } else {
                child.setParentCode(parentCode);
            }
            Integer sortNumber = sortNumbers.getAndIncrement();
            // 保存数据
            SysArea sysArea = SysAreaConvert.INSTANCE.convertSysArea(child);
            sysArea.setSortNumber(sortNumber);
            if (save(sysArea)) {
                if (!CollectionUtils.isEmpty(child.getDistricts())) {
                    recursion(child.getDistricts(), child.getCode());
                }
            }
        });
    }

    @Override
    protected String getRegion() {
        return BizConstant.AREA;
    }
}
