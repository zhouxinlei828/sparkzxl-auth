package com.github.sparkzxl.auth.application.service;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.infrastructure.entity.TenantPool;
import com.github.sparkzxl.auth.interfaces.dto.tenant.TenantPoolQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.tenant.TenantPoolSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.tenant.TenantPoolUpdateDTO;
import com.github.sparkzxl.database.base.service.SuperCacheService;
import com.github.sparkzxl.database.dto.PageParams;

import java.util.List;

/**
 * description: 租户池信息 服务类
 *
 * @author charles.zhou
 * @date   2021-02-02 16:20:51
 */
public interface ITenantPoolService extends SuperCacheService<TenantPool> {

    /**
     * 分页查询租户池列表
     *
     * @param params 租户池分页查询参数
     * @return PageInfo<TenantPool>
     */
    PageInfo<TenantPool> getTenantPoolPageList(PageParams<TenantPoolQueryDTO> params);

    /**
     * 保存租户池信息
     *
     * @param TenantPoolSaveDTO 租户池保存对象
     * @return boolean
     */
    boolean saveTenantPool(TenantPoolSaveDTO TenantPoolSaveDTO);

    /**
     * 更新租户池信息
     *
     * @param TenantPoolUpdateDTO 租户池更新对象
     * @return boolean
     */
    boolean updateTenantPool(TenantPoolUpdateDTO TenantPoolUpdateDTO);

    /**
     * 删除租户池
     *
     * @param tenantPoolId 租户池id
     * @return boolean
     */
    boolean deleteTenantPool(Long tenantPoolId);

    /**
     * 批量删除租户池
     * @param tenantPoolIds 租户池ids
     * @return boolean
     */
    boolean deleteBatchTenantPool(List<Long> tenantPoolIds);

    /**
     * check 租户池信息
     *
     * @param tenantId 租户池code
     * @return boolean
     */
    boolean checkTenantId(String tenantId);
}
