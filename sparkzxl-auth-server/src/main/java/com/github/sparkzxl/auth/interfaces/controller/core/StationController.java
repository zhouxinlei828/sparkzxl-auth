package com.github.sparkzxl.auth.interfaces.controller.core;


import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.auth.application.event.ImportStationDataListener;
import com.github.sparkzxl.auth.application.service.ICoreStationService;
import com.github.sparkzxl.auth.domain.model.aggregates.excel.StationExcel;
import com.github.sparkzxl.auth.infrastructure.convert.CoreStationConvert;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.auth.interfaces.dto.station.StationQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.station.StationSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.station.StationUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.base.listener.ImportDataListener;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * description: 岗位 前端控制器
 *
 * @author charles.zhou
 * @date 2020-06-07 13:41:11
 */
@RestController
@ResponseResult
@HttpRequestLog
@Api(tags = "岗位管理")
@RequestMapping("/station")
public class StationController extends SuperCacheController<ICoreStationService, Long,
        CoreStation, StationSaveDTO, StationUpdateDTO, StationQueryDTO, StationExcel> {

    private ImportStationDataListener importStationDataListener;

    @Autowired
    public void setImportStationDataListener(ImportStationDataListener importStationDataListener) {
        this.importStationDataListener = importStationDataListener;
    }

    @Override
    public PageInfo<CoreStation> page(PageParams<StationQueryDTO> params) {
        return baseService.getStationPageList(params);
    }

    @Override
    public boolean save(StationSaveDTO stationSaveDTO) {
        return baseService.saveCoreStation(stationSaveDTO);
    }

    @Override
    public boolean update(StationUpdateDTO stationUpdateDTO) {
        return baseService.updateCoreStation(stationUpdateDTO);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteCoreStation(deleteDTO.getIds());
    }

    @Override
    public List<StationExcel> convertExcels(List<CoreStation> stationList) {
        return CoreStationConvert.INSTANCE.convertStationExcels(stationList);
    }

    @Override
    public ImportDataListener<StationExcel> getImportDataListener() {
        return importStationDataListener;
    }

    @Override
    public Class<?> importExcelClass() {
        return StationExcel.class;
    }

}
