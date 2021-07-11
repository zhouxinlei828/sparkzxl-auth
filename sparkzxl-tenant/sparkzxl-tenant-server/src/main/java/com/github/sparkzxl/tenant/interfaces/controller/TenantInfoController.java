package com.github.sparkzxl.tenant.interfaces.controller;


import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.annotation.result.WebResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.tenant.api.TenantApi;
import com.github.sparkzxl.tenant.api.dto.TenantInfoVO;
import com.github.sparkzxl.tenant.application.service.ITenantInfoService;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantInfo;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoQueryDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoSaveDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoUpdateDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 租户信息管理
 *
 * @author charles.zhou
 * @date 2021-02-02 16:21:52
 */
@RestController
@WebResult
@Api(tags = "租户信息管理")
@RequestMapping("/tenant/info")
public class TenantInfoController extends SuperCacheController<ITenantInfoService, Long,
        TenantInfo, TenantInfoSaveDTO, TenantInfoUpdateDTO, TenantInfoQueryDTO, Object> implements TenantApi {

    @Override
    public PageInfo<TenantInfo> page(PageParams<TenantInfoQueryDTO> params) {
        return baseService.getTenantInfoPageList(params);
    }

    @Override
    public boolean save(TenantInfoSaveDTO tenantInfoSaveDTO) {
        return baseService.saveTenantInfo(tenantInfoSaveDTO);
    }

    @Override
    public boolean update(TenantInfoUpdateDTO tenantInfoUpdateDTO) {
        return baseService.updateTenantInfo(tenantInfoUpdateDTO);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteBatchTenantInfo(deleteDTO.getIds());
    }

    @Override
    public List<TenantInfoVO> getTenantInfoList() {
        return baseService.getTenantInfoList();
    }
}
