package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtBusTableService;
import com.github.sparkzxl.workflow.domain.repository.IExtBusTableRepository;
import com.github.sparkzxl.workflow.infrastructure.convert.ExtBusTableConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableMapper;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableSaveDTO;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableUpdateDTO;
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

    @Autowired
    public void setBusTableRepository(IExtBusTableRepository busTableRepository) {
        this.busTableRepository = busTableRepository;
    }

    @Override
    public boolean saveBusTable(BusTableSaveDTO busTableSaveDTO) {
        return busTableRepository.saveBusTable(ExtBusTableConvert.INSTANCE.convertExtBusTable(busTableSaveDTO));
    }

    @Override
    public boolean updateBusTable(BusTableUpdateDTO busTableUpdateDTO) {
        return busTableRepository.updateBusTable(ExtBusTableConvert.INSTANCE.convertExtBusTable(busTableUpdateDTO));
    }

    @Override
    public boolean deleteBusTable(List<Long> ids) {
        return busTableRepository.deleteBusTable(ids);
    }

    @Override
    protected String getRegion() {
        return "ext_bus_table";
    }
}
