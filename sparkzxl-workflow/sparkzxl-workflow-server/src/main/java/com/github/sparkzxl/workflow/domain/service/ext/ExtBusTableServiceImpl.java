package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.es.IEsExtBusTableService;
import com.github.sparkzxl.workflow.application.service.ext.IExtBusTableService;
import com.github.sparkzxl.workflow.domain.repository.IExtBusTableRepository;
import com.github.sparkzxl.workflow.infrastructure.convert.ExtBusTableConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableMapper;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableSaveDTO;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableUpdateDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 业务表结构 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-26 11:23:23
 */
@Service
public class ExtBusTableServiceImpl extends SuperCacheServiceImpl<ExtBusTableMapper, ExtBusTable> implements IExtBusTableService {

    private IExtBusTableRepository busTableRepository;
    private IEsExtBusTableService esExtBusTableService;

    @Autowired
    public void setBusTableRepository(IExtBusTableRepository busTableRepository) {
        this.busTableRepository = busTableRepository;
    }

    @Autowired
    public void setEsExtBusTableService(IEsExtBusTableService esExtBusTableService) {
        this.esExtBusTableService = esExtBusTableService;
    }

    @Override
    public boolean saveBusTable(BusTableSaveDTO busTableSaveDTO) {
        boolean result = busTableRepository.saveBusTable(ExtBusTableConvert.INSTANCE.convertExtBusTable(busTableSaveDTO));
        esExtBusTableService.createIndex(busTableSaveDTO.getTableName(), null);
        return result;
    }

    @Override
    public boolean updateBusTable(BusTableUpdateDTO busTableUpdateDTO) {
        boolean result = busTableRepository.updateBusTable(ExtBusTableConvert.INSTANCE.convertExtBusTable(busTableUpdateDTO));
        esExtBusTableService.deleteIndex(busTableUpdateDTO.getTableName());
        esExtBusTableService.createIndex(busTableUpdateDTO.getTableName(), null);
        return result;
    }

    @Override
    public boolean deleteBusTable(List<Long> ids) {
        List<String> tableNames = busTableRepository.deleteBusTable(ids);
        if (CollectionUtils.isNotEmpty(tableNames)) {
            tableNames.forEach(tableName -> {
                esExtBusTableService.deleteIndex(tableName);
            });
        }
        return true;
    }

    @Override
    protected String getRegion() {
        return "ext_bus_table";
    }
}
