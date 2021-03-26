package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtBusTableService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableMapper;
import org.springframework.stereotype.Service;

/**
 * description: 业务表结构 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-26 11:23:23
 */
@Service
public class ExtBusTableServiceImpl extends SuperCacheServiceImpl<ExtBusTableMapper, ExtBusTable> implements IExtBusTableService {

    @Override
    protected String getRegion() {
        return "ext_bus_table";
    }
}
