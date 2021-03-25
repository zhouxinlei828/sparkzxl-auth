package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.sparkzxl.auth.application.service.IAreaService;
import com.github.sparkzxl.auth.domain.model.aggregates.City;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.entity.Area;
import com.github.sparkzxl.auth.infrastructure.mapper.AreaMapper;
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
public class AreaServiceImpl extends SuperCacheServiceImpl<AreaMapper, Area> implements IAreaService {

    @Override
    public List<Area> getAreaList(AreaQueryDTO areaQueryDTO) {
        LambdaQueryWrapper<Area> areaLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(areaQueryDTO.getCode())) {
            areaLambdaQueryWrapper.eq(Area::getCode, areaQueryDTO.getCode());
        }
        if (StringUtils.isNotEmpty(areaQueryDTO.getLabel())) {
            areaLambdaQueryWrapper.likeRight(Area::getLabel, areaQueryDTO.getLabel());
        }
        List<Area> areaList = list(areaLambdaQueryWrapper);
        return TreeUtil.buildTree(areaList);
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
        List<Area> areaList = Lists.newLinkedList();
        for (City city : cities) {
            Area area = new Area();
            area.setId((long) city.getCode());
            area.setParentId(0L);
            area.setLevel("PROVINCE");
            area.setSortValue(level1.getAndIncrement());
            area.setLabel(city.getName());
            areaList.add(area);
            count.getAndIncrement();
            List<City> children = city.getChildren();
            for (City child : children) {
                Area area1 = new Area();
                area1.setId((long) child.getCode());
                area1.setParentId((long) city.getCode());
                area1.setLevel("CITY");
                area1.setSortValue(level2.getAndIncrement());
                area1.setLabel(child.getName());
                areaList.add(area1);
                count.getAndIncrement();
                List<City> children1 = child.getChildren();
                for (City city2 : children1) {
                    Area area2 = new Area();
                    area2.setId((long) city2.getCode());
                    area2.setParentId((long) child.getCode());
                    area2.setLevel("COUNTY");
                    area2.setSortValue(level3.getAndIncrement());
                    area2.setLabel(city2.getName());
                    areaList.add(area2);
                    count.getAndIncrement();
                }
            }
        }
        int total = count.get();
        if (areaList.size() == total) {
            saveBatch(areaList, total);
        }
        log.info("导入地区数据共计：{} 条", total);

    }


    @Override
    protected String getRegion() {
        return CacheConstant.AREA;
    }
}
