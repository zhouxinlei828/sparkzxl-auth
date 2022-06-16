package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.auth.application.service.ICoreStationService;
import com.github.sparkzxl.auth.domain.repository.ICoreStationRepository;
import com.github.sparkzxl.auth.domain.repository.ISegmentIdRepository;
import com.github.sparkzxl.auth.infrastructure.convert.CoreStationConvert;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreStationMapper;
import com.github.sparkzxl.auth.domain.model.dto.station.StationQueryDTO;
import com.github.sparkzxl.auth.domain.model.dto.station.StationSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.station.StationUpdateDTO;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.dto.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 岗位 服务实现类
 *
 * @author charles.zhou
 * @since 2020-06-07 13:37:46
 */
@Service
public class CoreStationServiceImpl extends SuperServiceImpl<CoreStationMapper, CoreStation> implements ICoreStationService {

    @Autowired
    private ICoreStationRepository coreStationRepository;

    @Autowired
    private ISegmentIdRepository segmentIdRepository;


    @Override
    public Page<CoreStation> getStationPageList(PageParams<StationQueryDTO> params) {
        return coreStationRepository.getStationPagePage(params.getPageNum(),
                params.getPageSize(), params.getModel().getName(),
                params.getModel().getOrg());
    }

    @Override
    public boolean saveCoreStation(StationSaveDTO stationSaveDTO) {
        CoreStation coreStation = CoreStationConvert.INSTANCE.convertCoreStation(stationSaveDTO);
        long id = segmentIdRepository.getSegmentId("core_station").longValue();
        coreStation.setId(id);
        return save(coreStation);
    }

    @Override
    public boolean updateCoreStation(StationUpdateDTO stationUpdateDTO) {
        CoreStation coreStation = CoreStationConvert.INSTANCE.convertCoreStation(stationUpdateDTO);
        return updateById(coreStation);
    }

    @Override
    public CoreStation getCoreStationByName(String stationName) {
        return getOne(new LambdaQueryWrapper<CoreStation>()
                .eq(CoreStation::getName, stationName)
                .eq(CoreStation::getStatus, true).last("limit 1"));
    }


    @Override
    public boolean deleteCoreStation(List<Long> ids) {
        return coreStationRepository.deleteCoreStation(ids);
    }

}
