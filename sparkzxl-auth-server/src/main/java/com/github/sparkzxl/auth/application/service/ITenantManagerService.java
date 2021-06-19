package com.github.sparkzxl.auth.application.service;

import com.github.sparkzxl.auth.infrastructure.entity.TenantManager;
import com.github.sparkzxl.auth.interfaces.dto.manager.TenantManagerSaveDTO;
import com.github.sparkzxl.core.entity.AuthUserInfo;
import com.github.sparkzxl.database.base.service.SuperCacheService;

/**
 * description: 领域管理员 服务类
 *
 * @author zhouxinlei
 * @date 2021-03-19 20:55:15
 */
public interface ITenantManagerService extends SuperCacheService<TenantManager> {

    /**
     * 查询领域管理员账户信息
     *
     * @param username 账号
     * @return tenantManager
     */
    TenantManager getByAccount(String username);

    /**
     * 获取全局用户信息
     *
     * @param username 用户账户
     * @return AuthUserInfo<Long>
     */
    AuthUserInfo<Long> getAuthUserInfo(String username);

    /**
     * 领域管理员注册
     *
     * @param tenantManagerSaveDTO 领域管理员保存对象
     * @return boolean
     */
    boolean tenantManagerRegister(TenantManagerSaveDTO tenantManagerSaveDTO);
}
