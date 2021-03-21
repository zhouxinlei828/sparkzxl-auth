package com.github.sparkzxl.auth.domain.repository;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.infrastructure.entity.RealmPool;

import java.util.List;

/**
 * description: 领域池仓储类
 *
 * @author charles.zhou
 * @date 2021-02-14 10:11:05
 */
public interface IRealmPoolRepository {

    /**
     * 查询领域池列表
     *
     * @param pageNum     当前页
     * @param pageSize    分页大小
     * @param realmUserId 领域用户id
     * @param code        领域池编码
     * @param name        领域池名称
     * @return PageInfo<RealmPool>
     */
    PageInfo<RealmPool> getRealmPoolPageList(int pageNum, int pageSize, Long realmUserId, String code, String name);

    /**
     * 保存领域池信息
     *
     * @param realmPool 领域池信息
     * @return boolean
     */
    boolean saveRealmPool(RealmPool realmPool);

    /**
     * 更新领域池信息
     *
     * @param realmPool 领域池信息
     * @return boolean
     */
    boolean updateRealmPool(RealmPool realmPool);

    /**
     * 删除领域池信息
     *
     * @param realmPoolId 领域池id
     * @return boolean
     */
    boolean deleteRealmPool(Long realmPoolId);

    /**
     * 批量删除领域池信息
     *
     * @param realmPoolIds 领域池ids
     * @return boolean
     */
    boolean deleteBatchRealmPool(List<Long> realmPoolIds);
}
