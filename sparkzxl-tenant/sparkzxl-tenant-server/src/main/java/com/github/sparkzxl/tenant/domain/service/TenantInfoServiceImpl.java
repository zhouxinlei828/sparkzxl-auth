package com.github.sparkzxl.tenant.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.tenant.api.dto.TenantInfoVO;
import com.github.sparkzxl.tenant.application.service.ITenantInfoService;
import com.github.sparkzxl.tenant.domain.repository.ITenantInfoRepository;
import com.github.sparkzxl.tenant.infrastructure.convert.TenantInfoConvert;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantInfo;
import com.github.sparkzxl.tenant.infrastructure.mapper.TenantInfoMapper;
import com.github.sparkzxl.tenant.infrastructure.repository.TenantInfoRepository;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoQueryDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoSaveDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 租户信息 服务实现类
 *
 * @author charles.zhou
 * @date 2021-02-02 16:21:08
 */
@Service
public class TenantInfoServiceImpl extends SuperCacheServiceImpl<TenantInfoMapper, TenantInfo> implements ITenantInfoService {

    @Autowired
    private ITenantInfoRepository tenantInfoRepository;

    @Override
    public PageInfo<TenantInfo> getTenantInfoPageList(PageParams<TenantInfoQueryDTO> params) {
        return tenantInfoRepository.getTenantInfoPageList(params.getPageNum(), params.getPageSize(),
                params.getModel().getTenantUserId(), params.getModel().getCode(),
                params.getModel().getName());
    }

    @Override
    public boolean saveTenantInfo(TenantInfoSaveDTO TenantInfoSaveDTO) {
        TenantInfo tenantInfo = TenantInfoConvert.INSTANCE.convertTenantInfo(TenantInfoSaveDTO);
        return tenantInfoRepository.saveTenantInfo(tenantInfo);
    }

    @Override
    public boolean updateTenantInfo(TenantInfoUpdateDTO TenantInfoUpdateDTO) {
        TenantInfo tenantInfo = TenantInfoConvert.INSTANCE.convertTenantInfo(TenantInfoUpdateDTO);
        return tenantInfoRepository.updateTenantInfo(tenantInfo);
    }

    @Override
    public boolean deleteTenantInfo(Long TenantInfoId) {
        return tenantInfoRepository.deleteTenantInfo(TenantInfoId);
    }

    @Override
    public boolean deleteBatchTenantInfo(List<Long> TenantInfoIds) {
        return tenantInfoRepository.deleteBatchTenantInfo(TenantInfoIds);
    }

    @Override
    public boolean checkTenantId(String tenantId) {
        return count(new LambdaQueryWrapper<TenantInfo>().eq(TenantInfo::getCode, tenantId)) == 1;
    }

    @Override
    public List<TenantInfoVO> getTenantInfoList() {
        return TenantInfoConvert.INSTANCE.convertTenantInfoVO(list());
    }

    @Override
    protected String getRegion() {
        return "tenant_info";
    }
}
