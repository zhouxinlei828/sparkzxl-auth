package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.application.service.ITenantPoolService;
import com.github.sparkzxl.auth.domain.repository.ITenantPoolRepository;
import com.github.sparkzxl.auth.infrastructure.convert.TenantPoolConvert;
import com.github.sparkzxl.auth.infrastructure.entity.TenantPool;
import com.github.sparkzxl.auth.infrastructure.mapper.TenantPoolMapper;
import com.github.sparkzxl.auth.interfaces.dto.tenant.TenantPoolQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.tenant.TenantPoolSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.tenant.TenantPoolUpdateDTO;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.dto.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 租户池信息 服务实现类
 *
 * @author charles.zhou
 * @date 2021-02-02 16:21:08
 */
@Service
public class TenantPoolServiceImpl extends SuperCacheServiceImpl<TenantPoolMapper, TenantPool> implements ITenantPoolService {

    @Autowired
    private ITenantPoolRepository tenantPoolRepository;

    @Override
    public PageInfo<TenantPool> getTenantPoolPageList(PageParams<TenantPoolQueryDTO> params) {
        return tenantPoolRepository.getTenantPoolPageList(params.getPageNum(), params.getPageSize(),
                params.getModel().getTenantUserId(), params.getModel().getCode(),
                params.getModel().getName());
    }

    @Override
    public boolean saveTenantPool(TenantPoolSaveDTO tenantPoolSaveDTO) {
        TenantPool tenantPool = TenantPoolConvert.INSTANCE.convertTenantPool(tenantPoolSaveDTO);
        return tenantPoolRepository.saveTenantPool(tenantPool);
    }

    @Override
    public boolean updateTenantPool(TenantPoolUpdateDTO tenantPoolUpdateDTO) {
        TenantPool tenantPool = TenantPoolConvert.INSTANCE.convertTenantPool(tenantPoolUpdateDTO);
        return tenantPoolRepository.updateTenantPool(tenantPool);
    }

    @Override
    public boolean deleteTenantPool(Long tenantPoolId) {
        return tenantPoolRepository.deleteTenantPool(tenantPoolId);
    }

    @Override
    public boolean deleteBatchTenantPool(List<Long> tenantPoolIds) {
        return tenantPoolRepository.deleteBatchTenantPool(tenantPoolIds);
    }

    @Override
    public boolean checkTenantId(String tenantId) {
        return count(new LambdaQueryWrapper<TenantPool>().eq(TenantPool::getCode, tenantId)) == 1;
    }

    @Override
    protected String getRegion() {
        return "tenant_pool";
    }
}
