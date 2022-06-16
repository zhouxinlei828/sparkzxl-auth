package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IRoleAuthorityService;
import com.github.sparkzxl.auth.domain.repository.IRoleAuthorityRepository;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.auth.domain.model.dto.role.RoleAuthoritySaveDTO;
import com.github.sparkzxl.core.context.RequestLocalContextHolder;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 角色的资源 服务实现类
 *
 * @author charles.zhou
 * @since 2020-07-19 20:59:45
 */
@Service
public class RoleAuthorityServiceImpl extends SuperServiceImpl<RoleAuthorityMapper, RoleAuthority> implements IRoleAuthorityService {

    @Autowired
    private IRoleAuthorityRepository authorityRepository;

    @Override
    public boolean saveRoleAuthorityBatch(RoleAuthoritySaveDTO roleAuthoritySaveDTO) {
        return authorityRepository.saveRoleAuthorityBatch(roleAuthoritySaveDTO.getRoleId(),
                roleAuthoritySaveDTO.getResourceIds(),
                roleAuthoritySaveDTO.getMenuIds());
    }

    @Override
    public boolean refreshAuthorityList() {
        String tenantId = RequestLocalContextHolder.getTenant();
        return authorityRepository.refreshAuthorityList(tenantId);
    }
}
