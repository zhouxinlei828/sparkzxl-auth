package com.github.sparkzxl.tenant.domain.repository;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantInfo;

import java.util.List;

/**
 * description: 租户信息仓储类
 *
 * @author charles.zhou
 * @date 2021-02-14 10:11:05
 */
public interface ITenantInfoRepository {

    /**
     * 查询租户信息列表
     *
     * @param pageNum      当前页
     * @param pageSize     分页大小
     * @param tenantUserId 租户用户id
     * @param code         租户信息编码
     * @param name         租户信息名称
     * @return PageInfo<TenantInfo>
     */
    PageInfo<TenantInfo> getTenantInfoPageList(int pageNum, int pageSize, Long tenantUserId, String code, String name);

    /**
     * 查询租户信息列表
     *
     * @param tenantUserId 租户用户id
     * @return List<TenantInfo>
     */
    List<TenantInfo> getTenantInfoList(Long tenantUserId);

    /**
     * 保存租户信息
     *
     * @param tenantInfo 租户信息
     * @return boolean
     */
    boolean saveTenantInfo(TenantInfo tenantInfo);

    /**
     * 更新租户信息
     *
     * @param tenantInfo 租户信息
     * @return boolean
     */
    boolean updateTenantInfo(TenantInfo tenantInfo);

    /**
     * 删除租户信息
     *
     * @param TenantInfoId 租户信息id
     * @return boolean
     */
    boolean deleteTenantInfo(Long TenantInfoId);

    /**
     * 批量删除租户信息
     *
     * @param TenantInfoIds 租户信息ids
     * @return boolean
     */
    boolean deleteBatchTenantInfo(List<Long> TenantInfoIds);
}
