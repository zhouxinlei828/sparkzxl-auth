package com.github.sparkzxl.auth.domain.repository;


import com.github.sparkzxl.auth.domain.model.aggregates.RoleResource;
import com.github.sparkzxl.core.entity.AuthUserInfo;

import java.util.Set;

/**
 * description: 角色资源绑定 仓储类
 *
 * @author charles.zhou
 * @date 2020-07-19 21:12:43
 */
public interface IRoleAuthorityRepository {

    /**
     * 保存绝色资源
     *
     * @param roleId      角色id
     * @param resourceIds 菜单id列表
     * @param menuIds     资源id列表
     * @return boolean
     */
    boolean saveRoleAuthorityBatch(Long roleId, Set<Long> resourceIds, Set<Long> menuIds);

    /**
     * 查询角色资源信息
     *
     * @param roleId 角色id
     * @return RoleResource
     */
    RoleResource getRoleResource(Long roleId);

    /**
     * 根据领域池code刷新角色权限
     *
     * @param realmCode 角色id
     */
    void refreshAuthorityByRealmCode(String realmCode);


    /**
     * 刷新角色权限
     *
     * @param realmUserId 领域用户id
     */
    void refreshAuthorityList(Long realmUserId);

    /**
     * 刷新角色权限
     *
     * @param oldVal 旧值
     * @param newVal 新值
     */
    void refreshAuthority(String oldVal, String newVal);

    /**
     * 刷新角色权限
     *
     * @param oldVal 旧值
     */
    void refreshAuthority(String oldVal);

    /**
     * 刷新领域资源池权限
     *
     * @param authUserInfo 全局用户
     * @return boolean
     */
    boolean refreshRealmPoolAuthority(AuthUserInfo<Long> authUserInfo);

}
