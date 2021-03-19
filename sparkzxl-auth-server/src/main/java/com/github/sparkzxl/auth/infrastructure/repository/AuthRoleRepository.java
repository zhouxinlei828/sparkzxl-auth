package com.github.sparkzxl.auth.infrastructure.repository;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.domain.repository.IAuthRoleRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.entity.UserRole;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 角色 仓储层实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:31:48
 */
@Repository
public class AuthRoleRepository implements IAuthRoleRepository {

    private UserRoleMapper userRoleMapper;
    private RoleAuthorityMapper roleAuthorityMapper;
    private AuthRoleMapper authRoleMapper;

    @Autowired
    public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Autowired
    public void setRoleAuthorityMapper(RoleAuthorityMapper roleAuthorityMapper) {
        this.roleAuthorityMapper = roleAuthorityMapper;
    }

    @Autowired
    public void setAuthRoleMapper(AuthRoleMapper authRoleMapper) {
        this.authRoleMapper = authRoleMapper;
    }

    @Override
    public void deleteAuthRoleRelation(List<Long> ids) {
        userRoleMapper.delete(new LambdaUpdateWrapper<UserRole>().in(UserRole::getRoleId, ids));
        roleAuthorityMapper.delete(new LambdaUpdateWrapper<RoleAuthority>().in(RoleAuthority::getRoleId, ids));
    }

    @Override
    public void saveRole(AuthRole authRole) {
        authRoleMapper.insert(authRole);
    }

    @Override
    public void deleteAuthRole(String tenantCode) {
        userRoleMapper.deleteUserRole(tenantCode);
        roleAuthorityMapper.deleteRoleAuthority(tenantCode);
        authRoleMapper.deleteAuthRole(tenantCode);
    }
}
