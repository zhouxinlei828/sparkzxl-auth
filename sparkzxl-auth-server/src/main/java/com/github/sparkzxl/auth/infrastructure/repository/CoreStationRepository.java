package com.github.sparkzxl.auth.infrastructure.repository;


import cn.hutool.core.bean.OptionalBean;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.auth.domain.repository.ICoreStationRepository;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreStationMapper;
import com.github.sparkzxl.core.util.MapHelper;
import com.github.sparkzxl.entity.data.RemoteData;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description: 岗位 仓储层实现类
 *
 * @author charles.zhou
 * @since 2020-06-07 13:32:55
 */
@Repository
public class CoreStationRepository implements ICoreStationRepository {

    @Resource
    private CoreStationMapper coreStationMapper;

    @Override
    public Map<Serializable, Object> findByIds(Set<Serializable> ids) {
        List<CoreStation> stations = getStations(ids);
        return MapHelper.uniqueIndex(stations, CoreStation::getId, (station) -> station);
    }


    private List<CoreStation> getStations(Set<Serializable> ids) {
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> idList = ids.stream().mapToLong(Convert::toLong).boxed().collect(Collectors.toList());
        List<CoreStation> list;
        int size = 1000;
        if (idList.size() <= size) {
            list = idList.stream().map(coreStationMapper::selectById).filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            list = coreStationMapper.selectList(new LambdaQueryWrapper<CoreStation>()
                    .in(CoreStation::getId, idList)
                    .eq(CoreStation::getStatus, true));
        }
        return list;
    }

    @Override
    public Page<CoreStation> getStationPagePage(int pageNum, int pageSize, String name, RemoteData<Long, CoreOrg> org) {
        LambdaQueryWrapper<CoreStation> stationQueryWrapper = new LambdaQueryWrapper<>();
        Long orgId = OptionalBean.ofNullable(org).getBean(RemoteData::getKey).get();
        stationQueryWrapper.likeRight(StringUtils.isNotEmpty(name), CoreStation::getName, name)
                .eq(ObjectUtils.isNotEmpty(orgId), CoreStation::getOrg, org);
        return coreStationMapper.selectPage(new Page<>(pageNum, pageSize), stationQueryWrapper);
    }

    @Override
    public boolean deleteCoreStation(List<Long> ids) {
        coreStationMapper.deleteBatchIds(ids);
        return true;
    }
}
