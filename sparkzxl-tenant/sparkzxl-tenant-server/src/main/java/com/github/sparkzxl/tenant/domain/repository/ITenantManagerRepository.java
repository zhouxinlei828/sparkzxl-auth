package com.github.sparkzxl.tenant.domain.repository;

import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.entity.security.SecurityUserDetail;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantManager;

/**
 * description: 领域管理员仓储层
 *
 * @author charles.zhou
 * @date 2020-06-05 20:39:15
 */
public interface ITenantManagerRepository {

    /**
     * 根据账户查询用户信息
     *
     * @param account 账户
     * @return tenantManager
     */
    TenantManager selectByAccount(String account);

    /**
     * 保存领域管理员
     *
     * @param tenantManager 领域管理员
     * @return boolean
     */
    boolean saveTenantManager(TenantManager tenantManager);

    /**
     * 获取用户信息
     *
     * @param username 用户账户
     * @return AuthUserInfo<Long>
     */
    SecurityUserDetail<Long> getAuthUserDetail(String username);

    /**
     * 获取全局用户信息
     *
     * @param username 用户账户
     * @return AuthUserInfo<Long>
     */
    AuthUserInfo<Long> getAuthUserInfo(String username);
}
