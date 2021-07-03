package com.github.sparkzxl.tenant.infrastructure.repository;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.database.utils.PageInfoUtils;
import com.github.sparkzxl.tenant.domain.repository.ITenantPoolRepository;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantPool;
import com.github.sparkzxl.tenant.infrastructure.mapper.TenantPoolMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description: 租户池仓储实现类
 *
 * @author charles.zhou
 * @date 2021-02-14 10:13:48
 */
@Repository
public class TenantPoolRepository implements ITenantPoolRepository {

    @Autowired
    private TenantPoolMapper tenantPoolMapper;

    @Override
    public PageInfo<TenantPool> getTenantPoolPageList(int pageNum, int pageSize, Long tenantUserId, String code, String name) {
        LambdaQueryWrapper<TenantPool> tenantLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(code)) {
            tenantLambdaQueryWrapper.eq(TenantPool::getCode, code);
        }
        if (StringUtils.isNotEmpty(name)) {
            tenantLambdaQueryWrapper.likeLeft(TenantPool::getName, name);
        }
        tenantLambdaQueryWrapper.eq(TenantPool::getTenantUserId, tenantUserId);
        tenantLambdaQueryWrapper.orderByAsc(TenantPool::getCode);
        PageHelper.startPage(pageNum, pageSize);
        List<TenantPool> tenantList = tenantPoolMapper.selectList(tenantLambdaQueryWrapper);
        return PageInfoUtils.pageInfo(tenantList);
    }

    @Override
    public List<TenantPool> getTenantPoolList(Long tenantUserId) {
        LambdaQueryWrapper<TenantPool> tenantPoolLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtils.isNotEmpty(tenantUserId)) {
            tenantPoolLambdaQueryWrapper.eq(TenantPool::getTenantUserId, tenantUserId);
        }
        return tenantPoolMapper.selectList(tenantPoolLambdaQueryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveTenantPool(TenantPool tenantPool) {
        String tenantId = IdUtil.objectId();
        Long userId = BaseContextHolder.getUserId(Long.TYPE);
        tenantPool.setTenantUserId(userId);
        tenantPool.setCode(tenantId);
        tenantPoolMapper.insert(tenantPool);
        initTenantPoolData(tenantId);
        return true;
    }

    public void initTenantPoolData(String tenantId) {
        BaseContextHolder.setTenant(tenantId);
    }

    @Override
    public boolean updateTenantPool(TenantPool tenant) {
        return tenantPoolMapper.updateById(tenant) != 0;
    }

    @Override
    public boolean deleteTenantPool(Long tenantPoolId) {
        TenantPool tenantPool = tenantPoolMapper.selectById(tenantPoolId);
        return tenantPoolMapper.deleteById(tenantPoolId) != 0;
    }

    @Override
    public boolean deleteBatchTenantPool(List<Long> tenantPoolIds) {
        if (CollectionUtils.isNotEmpty(tenantPoolIds)) {
            tenantPoolIds.forEach(this::deleteTenantPool);
        }
        return true;
    }
}
