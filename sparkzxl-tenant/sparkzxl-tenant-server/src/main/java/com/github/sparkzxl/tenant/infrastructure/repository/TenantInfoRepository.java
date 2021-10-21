package com.github.sparkzxl.tenant.infrastructure.repository;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.database.utils.PageInfoUtils;
import com.github.sparkzxl.tenant.domain.repository.ITenantInfoRepository;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantInfo;
import com.github.sparkzxl.tenant.infrastructure.mapper.TenantInfoMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description: 租户信息仓储实现类
 *
 * @author charles.zhou
 * @date 2021-02-14 10:13:48
 */
@Repository
public class TenantInfoRepository implements ITenantInfoRepository {

    @Autowired
    private TenantInfoMapper TenantInfoMapper;

    @Override
    public PageInfo<TenantInfo> getTenantInfoPageList(int pageNum, int pageSize, Long tenantUserId, String code, String name) {
        LambdaQueryWrapper<TenantInfo> tenantLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(code)) {
            tenantLambdaQueryWrapper.eq(TenantInfo::getCode, code);
        }
        if (StringUtils.isNotEmpty(name)) {
            tenantLambdaQueryWrapper.likeLeft(TenantInfo::getName, name);
        }
        tenantLambdaQueryWrapper.eq(TenantInfo::getTenantUserId, tenantUserId);
        tenantLambdaQueryWrapper.orderByAsc(TenantInfo::getCode);
        PageHelper.startPage(pageNum, pageSize);
        List<TenantInfo> tenantList = TenantInfoMapper.selectList(tenantLambdaQueryWrapper);
        return PageInfoUtils.pageInfo(tenantList);
    }

    @Override
    public List<TenantInfo> getTenantInfoList(Long tenantUserId) {
        LambdaQueryWrapper<TenantInfo> TenantInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtils.isNotEmpty(tenantUserId)) {
            TenantInfoLambdaQueryWrapper.eq(TenantInfo::getTenantUserId, tenantUserId);
        }
        return TenantInfoMapper.selectList(TenantInfoLambdaQueryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveTenantInfo(TenantInfo tenantInfo) {
        String tenantId = IdUtil.objectId();
        Long userId = BaseContextHolder.getUserId(Long.TYPE);
        tenantInfo.setTenantUserId(userId);
        tenantInfo.setCode(tenantId);
        TenantInfoMapper.insert(tenantInfo);
        initTenantInfoData(tenantId);
        return true;
    }

    public void initTenantInfoData(String tenantId) {
        BaseContextHolder.setTenant(tenantId);
    }

    @Override
    public boolean updateTenantInfo(TenantInfo tenant) {
        return TenantInfoMapper.updateById(tenant) != 0;
    }

    @Override
    public boolean deleteTenantInfo(Long TenantInfoId) {
        TenantInfo tenantInfo = TenantInfoMapper.selectById(TenantInfoId);
        return TenantInfoMapper.deleteById(TenantInfoId) != 0;
    }

    @Override
    public boolean deleteBatchTenantInfo(List<Long> TenantInfoIds) {
        if (CollectionUtils.isNotEmpty(TenantInfoIds)) {
            TenantInfoIds.forEach(this::deleteTenantInfo);
        }
        return true;
    }
}
