package com.github.sparkzxl.auth.infrastructure.repository;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.domain.repository.IAuthRoleRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRoleAttribute;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.entity.UserRole;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleAttributeMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.UserRoleMapper;
import org.apache.commons.collections4.CollectionUtils;
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
    private AuthRoleAttributeMapper roleAttributeMapper;

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

    @Autowired
    public void setRoleAttributeMapper(AuthRoleAttributeMapper roleAttributeMapper) {
        this.roleAttributeMapper = roleAttributeMapper;
    }

    @Override
    public void deleteAuthRoleRelation(List<Long> ids) {
        userRoleMapper.delete(new LambdaUpdateWrapper<UserRole>().in(UserRole::getRoleId, ids));
        roleAuthorityMapper.delete(new LambdaUpdateWrapper<RoleAuthority>().in(RoleAuthority::getRoleId, ids));
        roleAttributeMapper.delete(new LambdaQueryWrapper<AuthRoleAttribute>().in(AuthRoleAttribute::getRoleId, ids));
    }

    @Override
    public boolean saveRole(AuthRole authRole) {
        authRoleMapper.insert(authRole);
        List<AuthRoleAttribute> roleAttributes = authRole.getRoleAttributes();
        if (CollectionUtils.isNotEmpty(roleAttributes)) {
            roleAttributes.forEach(roleAttribute -> {
                roleAttribute.setRoleId(authRole.getId());
                roleAttributeMapper.insert(roleAttribute);
            });
        }
        return true;
    }

    @Override
    public void deleteAuthRole(String realmCode) {
        userRoleMapper.deleteUserRole(realmCode);
        roleAuthorityMapper.deleteRoleAuthority(realmCode);
        roleAttributeMapper.deleteAuthRoleAttribute(realmCode);
        authRoleMapper.deleteAuthRole(realmCode);
    }

    @Override
    public boolean updateRole(AuthRole authRole) {
        authRoleMapper.updateById(authRole);
        List<AuthRoleAttribute> roleAttributes = authRole.getRoleAttributes();
        roleAttributeMapper.delete(new LambdaQueryWrapper<AuthRoleAttribute>().eq(AuthRoleAttribute::getRoleId, authRole.getId()));
        if (CollectionUtils.isNotEmpty(roleAttributes)) {
            roleAttributes.forEach(roleAttribute -> {
                roleAttribute.setRoleId(authRole.getId());
                roleAttributeMapper.insert(roleAttribute);
            });
        }
        return true;
    }
}
