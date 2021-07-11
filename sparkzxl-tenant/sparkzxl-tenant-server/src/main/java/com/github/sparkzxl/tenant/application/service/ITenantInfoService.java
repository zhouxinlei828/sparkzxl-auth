package com.github.sparkzxl.tenant.application.service;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.database.base.service.SuperCacheService;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.tenant.api.dto.TenantInfoVO;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantInfo;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoQueryDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoSaveDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoUpdateDTO;

import java.util.List;

/**
 * description: 租户信息 服务类
 *
 * @author charles.zhou
 * @date 2021-02-02 16:20:51
 */
public interface ITenantInfoService extends SuperCacheService<TenantInfo> {

    /**
     * 分页查询租户信息列表
     *
     * @param params 租户信息分页查询参数
     * @return PageInfo<TenantInfo>
     */
    PageInfo<TenantInfo> getTenantInfoPageList(PageParams<TenantInfoQueryDTO> params);

    /**
     * 保存租户信息
     *
     * @param TenantInfoSaveDTO 租户信息保存对象
     * @return boolean
     */
    boolean saveTenantInfo(TenantInfoSaveDTO TenantInfoSaveDTO);

    /**
     * 更新租户信息
     *
     * @param TenantInfoUpdateDTO 租户信息更新对象
     * @return boolean
     */
    boolean updateTenantInfo(TenantInfoUpdateDTO TenantInfoUpdateDTO);

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

    /**
     * check 租户信息
     *
     * @param tenantId 租户信息code
     * @return boolean
     */
    boolean checkTenantId(String tenantId);

    /**
     * 查询租户列表
     *
     * @return List<TenantInfoVO>
     */
    List<TenantInfoVO> getTenantInfoList();

}
