package com.github.sparkzxl.auth.infrastructure.repository;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.auth.domain.repository.IAuthRoleRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.entity.UserRole;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.UserRoleMapper;
import com.github.sparkzxl.entity.data.SuperEntity;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
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
    public boolean saveRole(AuthRole authRole) {
        return authRoleMapper.insert(authRole) == 1;
    }

    @Override
    public boolean updateRole(AuthRole authRole) {
        LambdaUpdateWrapper<AuthRole> updateWrapper = new LambdaUpdateWrapper<>();
        if (MapUtils.isEmpty(authRole.getExtendInfo())) {
            updateWrapper.set(AuthRole::getExtendInfo, null);
        }
        updateWrapper.eq(SuperEntity::getId, authRole.getId());
        return authRoleMapper.update(authRole, updateWrapper) == 1;
    }

    @Override
    public Page<AuthRole> getPageList(int pageNum, int pageSize, String code, String name) {
        LambdaUpdateWrapper<AuthRole> roleLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        roleLambdaUpdateWrapper.eq(StringUtils.isNotEmpty(code), AuthRole::getCode, code)
                .likeRight(StringUtils.isNotEmpty(name), AuthRole::getName, name);
        return authRoleMapper.selectPage(new Page<>(pageNum, pageSize), roleLambdaUpdateWrapper);
    }
}
