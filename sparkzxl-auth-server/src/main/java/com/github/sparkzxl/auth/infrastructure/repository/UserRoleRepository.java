package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.sparkzxl.auth.domain.repository.IUserRoleRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.UserRole;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthUserMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.UserRoleMapper;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description:账户角色绑定 仓储实现类
 *
 * @author charles.zhou
 * @date   2020-07-19 21:19:03
 */
@AllArgsConstructor
@Repository
public class UserRoleRepository implements IUserRoleRepository {

    private final UserRoleMapper userRoleMapper;
    private final AuthUserMapper authUserMapper;

    @Override
    public boolean saveAuthRoleUser(Long roleId, List<Long> userIds) {
        List<UserRole> userRoles = new ArrayList<>(userIds.size());
        userRoleMapper.delete(new LambdaUpdateWrapper<UserRole>().eq(UserRole::getRoleId,roleId));
        if (CollectionUtils.isNotEmpty(userIds)){
            userIds.forEach(userId -> {
                UserRole userRole = new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(userId);
                userRoles.add(userRole);
            });
            userRoleMapper.insertBatchSomeColumn(userRoles);
        }
        return true;
    }

    @Override
    public boolean deleteAuthRoleUser(Long id, Set<Serializable> userIds) {
        userIds.forEach(userId -> userRoleMapper.delete(new UpdateWrapper<UserRole>().lambda().eq(UserRole::getRoleId, id).eq(UserRole::getUserId, userId)));
        return true;
    }

    @Override
    public List<AuthUser> getRoleUserList(Long roleId) {
        List<UserRole> userRoles = userRoleMapper.selectList(new LambdaQueryWrapper<UserRole>()
                .eq(UserRole::getRoleId, roleId));
        List<Long> userIds = userRoles.stream().filter(x -> x.getUserId() != null).map(UserRole::getUserId).distinct()
                .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(userIds)) {
            return authUserMapper.selectBatchIds(userIds);
        }
        return null;
    }
}
