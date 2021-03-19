package com.github.sparkzxl.auth.domain.repository;

import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * description: 账户角色绑定 仓储类
 *
 * @author charles.zhou
 * @date   2020-07-19 21:12:43
 */
public interface IUserRoleRepository {

    /**
     * 保存角色用户
     *
     * @param roleId
     * @param userIds
     * @return
     */
    boolean saveAuthRoleUser(Long roleId, List<Long> userIds);

    /**
     * 删除角色用户
     *
     * @param id
     * @param userIds
     * @return
     */
    boolean deleteAuthRoleUser(Long id, Set<Serializable> userIds);

    /**
     * 查询角色用户列表
     *
     * @param roleId 角色id
     * @return List<AuthUser>
     */
    List<AuthUser> getRoleUserList(Long roleId);
}
