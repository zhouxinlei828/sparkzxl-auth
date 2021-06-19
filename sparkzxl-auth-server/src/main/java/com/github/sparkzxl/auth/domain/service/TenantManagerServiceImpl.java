package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.ITenantManagerService;
import com.github.sparkzxl.auth.domain.repository.ITenantManagerRepository;
import com.github.sparkzxl.auth.infrastructure.convert.TenantManagerConvert;
import com.github.sparkzxl.auth.infrastructure.entity.TenantManager;
import com.github.sparkzxl.auth.infrastructure.mapper.TenantManagerMapper;
import com.github.sparkzxl.auth.interfaces.dto.manager.TenantManagerSaveDTO;
import com.github.sparkzxl.core.entity.AuthUserInfo;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
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
    public AuthUserInfo<Long> getAuthUserInfo(String username) {
        TenantManager tenantManager = tenantManagerRepository.selectByAccount(username);
        if (ObjectUtils.isNotEmpty(tenantManager)) {
            return UserDetailsServiceImpl.buildAuthUserInfo(tenantManager, Lists.newArrayList("TENANT_MANAGER"));
        }
        return null;
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
