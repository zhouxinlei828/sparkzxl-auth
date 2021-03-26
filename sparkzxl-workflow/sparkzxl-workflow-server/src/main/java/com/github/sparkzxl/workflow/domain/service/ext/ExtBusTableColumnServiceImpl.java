package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtBusTableColumnService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTableColumn;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableColumnMapper;
import org.springframework.stereotype.Service;

/**
 * description: 业务表字段 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-26 11:24:23
 */
@Service
public class ExtBusTableColumnServiceImpl extends SuperCacheServiceImpl<ExtBusTableColumnMapper, ExtBusTableColumn> implements IExtBusTableColumnService {

    @Override
    protected String getRegion() {
        return "ext_bus_table_column";
    }
}
