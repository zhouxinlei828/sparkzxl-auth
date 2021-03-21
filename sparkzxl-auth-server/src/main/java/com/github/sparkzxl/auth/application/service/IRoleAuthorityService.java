package com.github.sparkzxl.auth.application.service;

import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleAuthoritySaveDTO;
import com.github.sparkzxl.core.entity.AuthUserInfo;
import com.github.sparkzxl.database.base.service.SuperCacheService;

/**
 * <p>
 * 角色的资源 服务类
 * </p>
 *
 * @author charles.zhou
 * @since 2020-07-19
 */
public interface IRoleAuthorityService extends SuperCacheService<RoleAuthority> {

    /**
     * 保存角色资源
     *
     * @param roleAuthoritySaveDTO 角色资源保存对象
     * @return boolean
     */
    boolean saveRoleAuthorityBatch(RoleAuthoritySaveDTO roleAuthoritySaveDTO);

    /**
     * 刷新角色权限
     *
     * @param realmUserId 领域用户id
     */
    void refreshAuthorityList(Long realmUserId);

    /**
     * 刷新角色权限
     *
     * @param authUserInfo 全局用户
     * @return boolean
     */
    boolean refreshRealmPoolAuthority(AuthUserInfo<Long> authUserInfo);

}
