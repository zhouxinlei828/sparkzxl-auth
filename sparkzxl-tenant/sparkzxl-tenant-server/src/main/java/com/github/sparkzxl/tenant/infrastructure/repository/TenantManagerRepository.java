package com.github.sparkzxl.tenant.infrastructure.repository;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.entity.security.SecurityUserDetail;
import com.github.sparkzxl.tenant.domain.repository.ITenantManagerRepository;
import com.github.sparkzxl.tenant.infrastructure.convert.TenantManagerConvert;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantManager;
import com.github.sparkzxl.tenant.infrastructure.mapper.TenantManagerMapper;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 * description: 领域管理员仓储层实现类
 *
 * @author charles.zhou
 * @date 2020-06-05 20:39:15
 */
@Repository
public class TenantManagerRepository implements ITenantManagerRepository {

    private TenantManagerMapper tenantManagerMapper;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setTenantManagerMapper(TenantManagerMapper tenantManagerMapper) {
        this.tenantManagerMapper = tenantManagerMapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TenantManager selectByAccount(String account) {
        LambdaQueryWrapper<TenantManager> queryWrapper = new LambdaQueryWrapper<>();
        boolean mobile = Validator.isMobile(account);
        if (mobile) {
            queryWrapper.eq(TenantManager::getMobile, account);
        } else {
            queryWrapper.eq(TenantManager::getAccount, account);
        }
        queryWrapper.eq(TenantManager::getStatus, true);
        return tenantManagerMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean saveTenantManager(TenantManager tenantManager) {
        String account = tenantManager.getAccount();
        boolean mobile = Validator.isMobile(account);
        LambdaQueryWrapper<TenantManager> tenantManagerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (mobile) {
            tenantManagerLambdaQueryWrapper.eq(TenantManager::getMobile, account);
        } else {
            tenantManagerLambdaQueryWrapper.eq(TenantManager::getAccount, account);
        }
        Integer count = tenantManagerMapper.selectCount(tenantManagerLambdaQueryWrapper);
        if (count > 0) {
            ExceptionAssert.failure("账户重复，请勿重复注册");
        }
        tenantManager.setName(account);
        tenantManager.setStatus(true);
        String encodePassword = passwordEncoder.encode(tenantManager.getPassword());
        tenantManager.setPassword(encodePassword);
        if (mobile) {
            tenantManager.setMobile(account);
        }
        return tenantManagerMapper.insert(tenantManager) == 1;
    }

    @Override
    public SecurityUserDetail<Long> getAuthUserDetail(String username) {
        TenantManager tenantManager = selectByAccount(username);
        if (ObjectUtils.isNotEmpty(tenantManager)) {
            return new SecurityUserDetail<>(
                    tenantManager.getId(),
                    tenantManager.getAccount(),
                    tenantManager.getPassword(),
                    tenantManager.getName(),
                    tenantManager.getStatus(),
                    Lists.newArrayList("ADMIN"));
        }
        return null;
    }

    @Override
    public AuthUserInfo<Long> getAuthUserInfo(String username) {
        TenantManager tenantManager = selectByAccount(username);
        AuthUserInfo<Long> authUserInfo = TenantManagerConvert.INSTANCE.convertAuthUserInfo(tenantManager);
        authUserInfo.setAuthorityList(Lists.newArrayList("ADMIN"));
        return authUserInfo;
    }
}
