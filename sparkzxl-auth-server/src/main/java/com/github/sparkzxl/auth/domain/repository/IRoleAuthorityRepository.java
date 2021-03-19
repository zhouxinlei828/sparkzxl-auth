package com.github.sparkzxl.auth.domain.repository;


import com.github.sparkzxl.auth.domain.model.aggregates.RoleResource;

import java.util.Set;

/**
 * description: 角色资源绑定 仓储类
 *
 * @author charles.zhou
 * @date   2020-07-19 21:12:43
 */
public interface IRoleAuthorityRepository {

    /**
     * 保存绝色资源
     *
     * @param roleId        角色id
     * @param resourceIds 菜单id列表
     * @param menuIds 资源id列表
     * @return boolean
     */
    boolean saveRoleAuthorityBatch(Long roleId, Set<Long> resourceIds, Set<Long> menuIds);

    /**
     * 查询角色资源信息
     * @param roleId 角色id
     * @return RoleResource
     */
    RoleResource getRoleResource(Long roleId);

    /**
     * 刷新角色权限
     * @return boolean
     */
    boolean refreshAuthority();
}
