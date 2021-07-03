package com.github.sparkzxl.tenant.interfaces.controller;


import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.annotation.result.WebResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.tenant.application.service.ITenantPoolService;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantPool;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantPoolQueryDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantPoolSaveDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantPoolUpdateDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 租户池管理
 *
 * @author charles.zhou
 * @date 2021-02-02 16:21:52
 */
@RestController
@WebResult
@Api(tags = "租户池管理")
@RequestMapping("/tenant/pool")
public class TenantPoolController extends SuperCacheController<ITenantPoolService, Long,
        TenantPool, TenantPoolSaveDTO, TenantPoolUpdateDTO, TenantPoolQueryDTO, Object> {

    @Override
    public PageInfo<TenantPool> page(PageParams<TenantPoolQueryDTO> params) {
        return baseService.getTenantPoolPageList(params);
    }

    @Override
    public boolean save(TenantPoolSaveDTO tenantPoolSaveDTO) {
        return baseService.saveTenantPool(tenantPoolSaveDTO);
    }

    @Override
    public boolean update(TenantPoolUpdateDTO tenantPoolUpdateDTO) {
        return baseService.updateTenantPool(tenantPoolUpdateDTO);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteBatchTenantPool(deleteDTO.getIds());
    }

}
