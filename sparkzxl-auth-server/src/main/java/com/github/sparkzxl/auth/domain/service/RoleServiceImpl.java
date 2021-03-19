package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IRoleService;
import com.github.sparkzxl.auth.domain.repository.IAuthRoleRepository;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleMapper;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 角色 服务实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:37:09
 */
@Service
public class RoleServiceImpl extends SuperCacheServiceImpl<AuthRoleMapper, AuthRole> implements IRoleService {

    private final IAuthRoleRepository authRoleRepository;

    public RoleServiceImpl(IAuthRoleRepository authRoleRepository) {
        this.authRoleRepository = authRoleRepository;
    }

    @Override
    public void deleteAuthRoleRelation(List<Long> ids) {
        authRoleRepository.deleteAuthRoleRelation(ids);
    }

    @Override
    public boolean updateAuthRoleStatus(Long userId, Long roleId, Boolean status) {
        AuthRole authRole = new AuthRole();
        authRole.setId(roleId);
        authRole.setStatus(status);
        authRole.setUpdateUser(userId);
        return updateById(authRole);
    }

    @Override
    protected String getRegion() {
        return CacheConstant.ROLE;
    }
}
