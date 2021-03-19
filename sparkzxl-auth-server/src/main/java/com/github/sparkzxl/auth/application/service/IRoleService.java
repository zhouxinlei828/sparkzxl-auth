package com.github.sparkzxl.auth.application.service;


import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.database.base.service.SuperCacheService;

import java.util.List;

/**
 * description: 角色 服务类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:31:48
 */
public interface IRoleService extends SuperCacheService<AuthRole> {

    /**
     * 删除角色信息
     *
     * @param ids ids
     */
    void deleteAuthRoleRelation(List<Long> ids);

    /**
     * 更新角色状态
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @param status 状态
     * @return boolean
     */
    boolean updateAuthRoleStatus(Long userId, Long roleId, Boolean status);
}
