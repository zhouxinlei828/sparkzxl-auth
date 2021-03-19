package com.github.sparkzxl.auth.domain.repository;

import com.github.sparkzxl.auth.infrastructure.entity.RealmManager;
import com.github.sparkzxl.core.entity.AuthUserInfo;

/**
 * description: 领域管理员仓储层
 *
 * @author charles.zhou
 * @date 2020-06-05 20:39:15
 */
public interface IRealmManagerRepository {

    /**
     * 根据账户查询用户信息
     *
     * @param account 账户
     * @return RealmManager
     */
    RealmManager selectByAccount(String account);

}
