package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IRoleAuthorityService;
import com.github.sparkzxl.auth.domain.repository.IRoleAuthorityRepository;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleAuthoritySaveDTO;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 角色的资源 服务实现类
 *
 * @author charles.zhou
 * @date 2020-07-19 20:59:45
 */
@Service
public class RoleAuthorityServiceImpl extends SuperCacheServiceImpl<RoleAuthorityMapper, RoleAuthority> implements IRoleAuthorityService {

    @Autowired
    private IRoleAuthorityRepository authorityRepository;

    @Override
    protected String getRegion() {
        return CacheConstant.ROLE_RESOURCE;
    }

    @Override
    public boolean saveRoleAuthorityBatch(RoleAuthoritySaveDTO roleAuthoritySaveDTO) {
        return authorityRepository.saveRoleAuthorityBatch(roleAuthoritySaveDTO.getRoleId(),
                roleAuthoritySaveDTO.getResourceIds(),
                roleAuthoritySaveDTO.getMenuIds());
    }

    @Override
    public boolean refreshAuthorityList() {
        String tenantId = BaseContextHolder.getTenant();
        return authorityRepository.refreshAuthorityList(tenantId);
    }
}
