package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.domain.model.aggregates.AuthUserBasicInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.RoleBasicInfo;
import com.github.sparkzxl.auth.domain.repository.ITenantManagerRepository;
import com.github.sparkzxl.auth.infrastructure.constant.RoleConstant;
import com.github.sparkzxl.auth.infrastructure.convert.TenantManagerConvert;
import com.github.sparkzxl.auth.infrastructure.entity.TenantManager;
import com.github.sparkzxl.auth.infrastructure.mapper.TenantManagerMapper;
import com.github.sparkzxl.core.entity.AuthUserInfo;
import com.github.sparkzxl.core.support.BizExceptionAssert;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 领域管理员仓储层实现类
 *
 * @author charles.zhou
 * @date 2020-06-05 20:39:15
 */
@Repository
public class TenantManagerRepository implements ITenantManagerRepository {

    private TenantManagerMapper tenantManagerMapper;

    private Snowflake snowflake;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setTenantManagerMapper(TenantManagerMapper tenantManagerMapper) {
        this.tenantManagerMapper = tenantManagerMapper;
    }

    @Autowired
    public void setSnowflake(Snowflake snowflake) {
        this.snowflake = snowflake;
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
    public AuthUserBasicInfo getAuthUserBasicInfo(Long id) {
        TenantManager tenantManager = tenantManagerMapper.selectById(id);
        AuthUserBasicInfo authUserBasicInfo = TenantManagerConvert.INSTANCE.convertAuthUserBasicInfo(tenantManager);
        authUserBasicInfo.setTenantStatus(true);
        RoleBasicInfo roleBasicInfo = new RoleBasicInfo();
        roleBasicInfo.setId(snowflake.nextId());
        roleBasicInfo.setCode(RoleConstant.TENANT_MANAGER_CODE);
        roleBasicInfo.setName("领域管理员");
        List<RoleBasicInfo> roleBasicInfos = Lists.newArrayList(roleBasicInfo);
        authUserBasicInfo.setRoleBasicInfos(roleBasicInfos);
        return authUserBasicInfo;
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
            BizExceptionAssert.businessFail("账户重复，请勿重复注册");
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
    public AuthUserInfo<Long> getAuthUserInfo(String username) {
        TenantManager tenantManager = selectByAccount(username);
        if (ObjectUtils.isNotEmpty(tenantManager)) {
            AuthUserInfo<Long> authUserInfo = TenantManagerConvert.INSTANCE.convertAuthUserInfo(tenantManager);
            List<String> authUserRoles = Lists.newArrayList(RoleConstant.TENANT_MANAGER_CODE);
            authUserInfo.setAuthorityList(authUserRoles);
            authUserInfo.setTenantStatus(true);
            return authUserInfo;
        }
        return null;
    }
}
