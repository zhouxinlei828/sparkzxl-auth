package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.sparkzxl.auth.application.service.IAreaService;
import com.github.sparkzxl.auth.domain.model.aggregates.City;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.entity.CommonArea;
import com.github.sparkzxl.auth.infrastructure.mapper.CommonAreaMapper;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaQueryDTO;
import com.github.sparkzxl.core.jackson.JsonUtil;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.utils.TreeUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description: 地区表 服务实现类
 *
 * @author charles.zhou
 * @date   2020-07-28 19:43:36
 */
@Slf4j
@Service
public class AreaServiceImpl extends SuperCacheServiceImpl<CommonAreaMapper, CommonArea> implements IAreaService {

    @Override
    public List<CommonArea> getAreaList(AreaQueryDTO areaQueryDTO) {
        LambdaQueryWrapper<CommonArea> areaLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(areaQueryDTO.getCode())) {
            areaLambdaQueryWrapper.eq(CommonArea::getCode, areaQueryDTO.getCode());
        }
        if (StringUtils.isNotEmpty(areaQueryDTO.getLabel())) {
            areaLambdaQueryWrapper.likeRight(CommonArea::getLabel, areaQueryDTO.getLabel());
        }
        List<CommonArea> commonAreaList = list(areaLambdaQueryWrapper);
        return TreeUtil.buildTree(commonAreaList);
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
            CompletableFuture.runAsync(() -> saveAreaData(cities));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void saveAreaData(List<City> cities) {
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger level1 = new AtomicInteger(0);
        AtomicInteger level2 = new AtomicInteger(0);
        AtomicInteger level3 = new AtomicInteger(0);
        List<CommonArea> commonAreaList = Lists.newLinkedList();
        for (City city : cities) {
            CommonArea commonArea = new CommonArea();
            commonArea.setId((long) city.getCode());
            commonArea.setParentId(0L);
            commonArea.setLevel("PROVINCE");
            commonArea.setSortValue(level1.getAndIncrement());
            commonArea.setLabel(city.getName());
            commonAreaList.add(commonArea);
            count.getAndIncrement();
            List<City> children = city.getChildren();
            for (City child : children) {
                CommonArea commonArea1 = new CommonArea();
                commonArea1.setId((long) child.getCode());
                commonArea1.setParentId((long) city.getCode());
                commonArea1.setLevel("CITY");
                commonArea1.setSortValue(level2.getAndIncrement());
                commonArea1.setLabel(child.getName());
                commonAreaList.add(commonArea1);
                count.getAndIncrement();
                List<City> children1 = child.getChildren();
                for (City city2 : children1) {
                    CommonArea commonArea2 = new CommonArea();
                    commonArea2.setId((long) city2.getCode());
                    commonArea2.setParentId((long) child.getCode());
                    commonArea2.setLevel("COUNTY");
                    commonArea2.setSortValue(level3.getAndIncrement());
                    commonArea2.setLabel(city2.getName());
                    commonAreaList.add(commonArea2);
                    count.getAndIncrement();
                }
            }
        }
        int total = count.get();
        if (commonAreaList.size() == total) {
            saveBatch(commonAreaList, total);
        }
        log.info("导入地区数据共计：{} 条", total);

    }


    @Override
    protected String getRegion() {
        return CacheConstant.AREA;
    }
}
