package com.github.sparkzxl.tenant.domain.service;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.tenant.application.service.ITenantManagerService;
import com.github.sparkzxl.tenant.domain.repository.ITenantManagerRepository;
import com.github.sparkzxl.tenant.infrastructure.convert.TenantManagerConvert;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantManager;
import com.github.sparkzxl.tenant.infrastructure.mapper.TenantManagerMapper;
import com.github.sparkzxl.tenant.interfaces.dto.manager.TenantManagerSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 领域管理员 服务实现类
 *
 * @author zhouxinlei
 * @date 2021-03-19 20:55:36
 */
@Service
public class TenantManagerServiceImpl extends SuperCacheServiceImpl<TenantManagerMapper, TenantManager> implements ITenantManagerService {

    private ITenantManagerRepository tenantManagerRepository;

    @Autowired
    public void setTenantManagerRepository(ITenantManagerRepository tenantManagerRepository) {
        this.tenantManagerRepository = tenantManagerRepository;
    }

    @Override
    public TenantManager getByAccount(String username) {
        return tenantManagerRepository.selectByAccount(username);
    }

    @Override
    public boolean tenantManagerRegister(TenantManagerSaveDTO tenantManagerSaveDTO) {
        return tenantManagerRepository.saveTenantManager(TenantManagerConvert.INSTANCE.convertTenantManager(tenantManagerSaveDTO));
    }

    @Override
    protected String getRegion() {
        return "TENANT_MANAGER";
    }
}
