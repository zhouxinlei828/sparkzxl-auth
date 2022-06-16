package com.github.sparkzxl.auth.application.event;

import com.alibaba.excel.context.AnalysisContext;
import com.github.sparkzxl.auth.application.service.ICoreStationService;
import com.github.sparkzxl.auth.domain.model.aggregates.excel.StationExcel;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.database.base.listener.ImportDataListener;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description: 岗位Excel导入监听
 *
 * @author charles.zhou
 * @since 2021-01-04 15:34:07
 */
@Component
@Slf4j
public class ImportStationDataListener extends ImportDataListener<StationExcel> {

    private ICoreStationService stationService;

    @Autowired
    public void setStationService(ICoreStationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！size：{}", list.size());
        List<CoreStation> stationList = Lists.newArrayList();
        list.forEach(item -> {
            CoreStation coreStation = new CoreStation();
            coreStation.setName(item.getName());
            coreStation.setDescribe(item.getDescribe());
            coreStation.setStatus(true);
            stationList.add(coreStation);
            count.getAndIncrement();
        });
        stationService.saveBatch(stationList);
    }
}
