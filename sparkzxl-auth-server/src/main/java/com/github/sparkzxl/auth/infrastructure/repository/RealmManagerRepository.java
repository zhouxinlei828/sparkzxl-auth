package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.sparkzxl.auth.domain.model.aggregates.AuthUserBasicInfo;
import com.github.sparkzxl.auth.domain.repository.IRealmManagerRepository;
import com.github.sparkzxl.auth.infrastructure.convert.RealmManagerConvert;
import com.github.sparkzxl.auth.infrastructure.entity.RealmManager;
import com.github.sparkzxl.auth.infrastructure.mapper.RealmManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * description: 领域管理员仓储层实现类
 *
 * @author charles.zhou
 * @date 2020-06-05 20:39:15
 */
@Repository
public class RealmManagerRepository implements IRealmManagerRepository {

    private RealmManagerMapper realmManagerMapper;

    @Autowired
    public void setRealmManagerMapper(RealmManagerMapper realmManagerMapper) {
        this.realmManagerMapper = realmManagerMapper;
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
        return authUserBasicInfo;
    }
}
