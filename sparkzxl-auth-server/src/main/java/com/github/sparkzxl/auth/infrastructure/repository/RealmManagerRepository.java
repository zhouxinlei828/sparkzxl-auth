package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.sparkzxl.auth.domain.model.aggregates.AuthUserBasicInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.RoleBasicInfo;
import com.github.sparkzxl.auth.domain.repository.IRealmManagerRepository;
import com.github.sparkzxl.auth.infrastructure.convert.RealmManagerConvert;
import com.github.sparkzxl.auth.infrastructure.entity.RealmManager;
import com.github.sparkzxl.auth.infrastructure.mapper.RealmManagerMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public void setRealmManagerMapper(RealmManagerMapper realmManagerMapper) {
        this.realmManagerMapper = realmManagerMapper;
    }

    @Autowired
    public void setSnowflake(Snowflake snowflake) {
        this.snowflake = snowflake;
    }

    @Override
    public RealmManager selectByAccount(String account) {
        QueryWrapper<RealmManager> queryWrapper = new QueryWrapper<>();
        boolean mobile = Validator.isMobile(account);
        if (mobile) {
            queryWrapper.lambda().eq(RealmManager::getMobile, account);
        } else {
            queryWrapper.lambda().eq(RealmManager::getAccount, account);
        }
        queryWrapper.lambda().eq(RealmManager::getStatus, true);
        return realmManagerMapper.selectOne(queryWrapper);
    }

    @Override
    public AuthUserBasicInfo getAuthUserBasicInfo(Long id) {
        RealmManager realmManager = realmManagerMapper.selectById(id);
        AuthUserBasicInfo authUserBasicInfo = RealmManagerConvert.INSTANCE.convertAuthUserBasicInfo(realmManager);
        authUserBasicInfo.setRealmStatus(true);
        RoleBasicInfo roleBasicInfo = new RoleBasicInfo();
        roleBasicInfo.setId(snowflake.nextId());
        roleBasicInfo.setName("领域管理员");
        List<RoleBasicInfo> roleBasicInfos = Lists.newArrayList(roleBasicInfo);
        authUserBasicInfo.setRoleBasicInfos(roleBasicInfos);
        return authUserBasicInfo;
    }
}
