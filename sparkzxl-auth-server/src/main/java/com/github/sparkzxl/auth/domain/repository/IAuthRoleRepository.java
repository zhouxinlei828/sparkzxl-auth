package com.github.sparkzxl.auth.domain.repository;


import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;

import java.util.List;

/**
 * description: 角色 仓储类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:31:48
 */
public interface IAuthRoleRepository {

    /**
     * 删除角色以及关联信息
     *
     * @param ids ids
     */
    void deleteAuthRoleRelation(List<Long> ids);

    /**
     * 保存角色
     *
     * @param authRole 角色信息
     */
    void saveRole(AuthRole authRole);

    /**
     * 根据领域池code删除角色信息
     * @param tenantCode 领域池code
     */
    void deleteAuthRole(String tenantCode);
}
