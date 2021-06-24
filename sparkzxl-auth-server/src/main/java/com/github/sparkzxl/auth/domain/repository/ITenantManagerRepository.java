package com.github.sparkzxl.auth.domain.repository;

import com.github.sparkzxl.auth.domain.model.aggregates.AuthUserBasicInfo;
import com.github.sparkzxl.auth.infrastructure.entity.TenantManager;
import com.github.sparkzxl.core.entity.AuthUserInfo;

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
     * 获取用户基本信息
     *
     * @param id 用户id
     * @return AuthUserBasicInfo
     */
    AuthUserBasicInfo getAuthUserBasicInfo(Long id);

    /**
     * 保存领域管理员
     *
     * @param tenantManager 领域管理员
     * @return boolean
     */
    boolean saveTenantManager(TenantManager tenantManager);

    /**
     * 获取全局用户信息
     *
     * @param username 用户账户
     * @return AuthUserInfo<Long>
     */
    AuthUserInfo<Long> getAuthUserInfo(String username);
}