package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.sparkzxl.auth.domain.model.aggregates.AuthUserBasicInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.RoleBasicInfo;
import com.github.sparkzxl.auth.domain.repository.IRealmManagerRepository;
import com.github.sparkzxl.auth.infrastructure.constant.RoleConstant;
import com.github.sparkzxl.auth.infrastructure.convert.RealmManagerConvert;
import com.github.sparkzxl.auth.infrastructure.entity.RealmManager;
import com.github.sparkzxl.auth.infrastructure.mapper.RealmManagerMapper;
import com.github.sparkzxl.core.support.BizExceptionAssert;
import com.google.common.collect.Lists;
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
public class RealmManagerRepository implements IRealmManagerRepository {

    private RealmManagerMapper realmManagerMapper;

    private Snowflake snowflake;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setRealmManagerMapper(RealmManagerMapper realmManagerMapper) {
        this.realmManagerMapper = realmManagerMapper;
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
    public RealmManager selectByAccount(String account) {
        LambdaQueryWrapper<RealmManager> queryWrapper = new LambdaQueryWrapper<>();
        boolean mobile = Validator.isMobile(account);
        if (mobile) {
            queryWrapper.eq(RealmManager::getMobile, account);
        } else {
            queryWrapper.eq(RealmManager::getAccount, account);
        }
        queryWrapper.eq(RealmManager::getStatus, true);
        return realmManagerMapper.selectOne(queryWrapper);
    }

    @Override
    public AuthUserBasicInfo getAuthUserBasicInfo(Long id) {
        RealmManager realmManager = realmManagerMapper.selectById(id);
        AuthUserBasicInfo authUserBasicInfo = RealmManagerConvert.INSTANCE.convertAuthUserBasicInfo(realmManager);
        authUserBasicInfo.setRealmStatus(true);
        RoleBasicInfo roleBasicInfo = new RoleBasicInfo();
        roleBasicInfo.setId(snowflake.nextId());
        roleBasicInfo.setCode(RoleConstant.REALM_MANAGER_CODE);
        roleBasicInfo.setName("领域管理员");
        List<RoleBasicInfo> roleBasicInfos = Lists.newArrayList(roleBasicInfo);
        authUserBasicInfo.setRoleBasicInfos(roleBasicInfos);
        return authUserBasicInfo;
    }

    @Override
    public boolean saveRealmManager(RealmManager realmManager) {
        String account = realmManager.getAccount();
        boolean mobile = Validator.isMobile(account);
        LambdaQueryWrapper<RealmManager> realmManagerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (mobile) {
            realmManagerLambdaQueryWrapper.eq(RealmManager::getMobile, account);
        } else {
            realmManagerLambdaQueryWrapper.eq(RealmManager::getAccount, account);
        }
        Integer count = realmManagerMapper.selectCount(realmManagerLambdaQueryWrapper);
        if (count > 0) {
            BizExceptionAssert.businessFail("账户重复，请勿重复注册");
        }
        realmManager.setName(account);
        realmManager.setStatus(true);
        String encodePassword = passwordEncoder.encode(realmManager.getPassword());
        realmManager.setPassword(encodePassword);
        if (mobile) {
            realmManager.setMobile(account);
        }
        return realmManagerMapper.insert(realmManager) == 1;
    }
}
