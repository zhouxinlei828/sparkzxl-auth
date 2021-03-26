package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtBusDatasourceService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusDatasource;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusDatasourceMapper;
import org.springframework.stereotype.Service;

/**
 * description: 业务数据源 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-26 11:25:25
 */
@Service
public class ExtBusDatasourceServiceImpl extends SuperCacheServiceImpl<ExtBusDatasourceMapper, ExtBusDatasource> implements IExtBusDatasourceService {

    @Override
    protected String getRegion() {
        return "ext_bus_datasource";
    }
}
