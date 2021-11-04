package com.github.sparkzxl.auth.domain.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.application.service.ISysAreaService;
import com.github.sparkzxl.auth.domain.model.vo.AreaTree;
import com.github.sparkzxl.auth.infrastructure.client.AreaClient;
import com.github.sparkzxl.auth.infrastructure.client.result.Area;
import com.github.sparkzxl.auth.infrastructure.client.result.ResponseEntity;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.convert.SysAreaConvert;
import com.github.sparkzxl.auth.infrastructure.entity.SysArea;
import com.github.sparkzxl.auth.infrastructure.mapper.SysAreaMapper;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaUpdateDTO;
import com.github.sparkzxl.core.tree.TreeUtils;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class SysAreaServiceImpl extends SuperCacheServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {

    /**
     * 标识符
     */
    private static final String NONE = "[]";
    private static final String STREET = "street";
    private static final String PROVINCE = "province";
    @Autowired
    private AreaClient areaClient;
    @Value("${area.key}")
    private String areaKey;

    @Override
    public List<AreaTree> getAreaList(AreaQueryDTO areaQueryDTO) {
        LambdaQueryWrapper<SysArea> areaLambdaQueryWrapper = new LambdaQueryWrapper<SysArea>()
                .eq(StringUtils.isNotEmpty(areaQueryDTO.getCode()), SysArea::getCode, areaQueryDTO.getCode())
                .likeRight(StringUtils.isNotEmpty(areaQueryDTO.getName()), SysArea::getName, areaQueryDTO.getName());
        List<SysArea> sysAreaList = list(areaLambdaQueryWrapper);
        List<AreaTree> areaTreeList = SysAreaConvert.INSTANCE.convertSysAreaList(sysAreaList);
        return TreeUtils.buildTree(areaTreeList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean getActiveArea(Integer subDistrict) {
        Map<String, Object> queryMap = Maps.newHashMap();
        queryMap.put("keywords", "");
        queryMap.put("subdistrict", subDistrict);
        queryMap.put("key", areaKey);
        ResponseEntity responseEntity = areaClient.getAreaList(queryMap);
        List<Area> areaList = responseEntity.getDistricts();
        areaList.forEach(country -> {
            // 获取国家下面的所有省份
            List<Area> provinceList = country.getDistricts();
            // 排序
            provinceList = provinceList.stream().sorted(Comparator.comparing(Area::getCode)).collect(Collectors.toList());
            AtomicInteger sortNumbers = new AtomicInteger(0);
            provinceList.forEach(province -> {
                Integer sortNumber = sortNumbers.getAndIncrement();
                // 保存数据
                if (StrUtil.equals(PROVINCE, province.getLevel())) {
                    province.setParentCode(0L);
                }
                SysArea sysArea = SysAreaConvert.INSTANCE.convertSysArea(province);
                sysArea.setSortNumber(sortNumber);
                if (save(sysArea)) {
                    List<Area> cityList = province.getDistricts();
                    recursion(cityList, province.getCode());
                }
            });
        });
        return true;
    }

    public void recursion(List<Area> cityList, Long parentCode) {
        if (CollectionUtils.isEmpty(cityList)) {
            return;
        }
        cityList = cityList.stream().sorted(Comparator.comparing(Area::getCode)).collect(Collectors.toList());
        // 对街道,乡镇adCode特殊处理
        for (int i = 0; i < cityList.size(); i++) {
            Area area = cityList.get(i);
            if (StrUtil.equals(STREET, area.getLevel())) {
                Long streetId = Long.valueOf(String.valueOf(area.getCode()).concat(String.format("%02d", i + 1)));
                area.setCode(streetId);
            }
        }
        AtomicInteger sortNumbers = new AtomicInteger(0);
        cityList.forEach(child -> {
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
    public boolean updateArea(AreaUpdateDTO updateDTO) {
        SysArea sysArea = SysAreaConvert.INSTANCE.convertSysArea(updateDTO);
        return updateById(sysArea);
    }


    @Override
    public boolean saveArea(AreaSaveDTO saveDTO) {
        SysArea sysArea = SysAreaConvert.INSTANCE.convertSysArea(saveDTO);
        return save(sysArea);
    }

    @Override
    protected String getRegion() {
        return BizConstant.AREA;
    }
}
