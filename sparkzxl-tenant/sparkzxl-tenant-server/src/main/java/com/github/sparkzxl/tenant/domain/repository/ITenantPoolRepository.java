package com.github.sparkzxl.tenant.domain.repository;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantPool;

import java.util.List;

/**
 * description: 租户池仓储类
 *
 * @author charles.zhou
 * @date 2021-02-14 10:11:05
 */
public interface ITenantPoolRepository {

    /**
     * 查询租户池列表
     *
     * @param pageNum     当前页
     * @param pageSize    分页大小
     * @param tenantUserId 领域用户id
     * @param code        租户池编码
     * @param name        租户池名称
     * @return PageInfo<TenantPool>
     */
    PageInfo<TenantPool> getTenantPoolPageList(int pageNum, int pageSize, Long tenantUserId, String code, String name);

    /**
     * 查询租户池列表
     *
     * @param tenantUserId 领域用户id
     * @return List<TenantPool>
     */
    List<TenantPool> getTenantPoolList(Long tenantUserId);

    /**
     * 保存租户池信息
     *
     * @param tenantPool 租户池信息
     * @return boolean
     */
    boolean saveTenantPool(TenantPool tenantPool);

    /**
     * 更新租户池信息
     *
     * @param tenantPool 租户池信息
     * @return boolean
     */
    boolean updateTenantPool(TenantPool tenantPool);

    /**
     * 删除租户池信息
     *
     * @param tenantPoolId 租户池id
     * @return boolean
     */
    boolean deleteTenantPool(Long tenantPoolId);

    /**
     * 批量删除租户池信息
     *
     * @param tenantPoolIds 租户池ids
     * @return boolean
     */
    boolean deleteBatchTenantPool(List<Long> tenantPoolIds);
}
