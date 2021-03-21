package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IRealmManagerService;
import com.github.sparkzxl.auth.domain.repository.IRealmManagerRepository;
import com.github.sparkzxl.auth.infrastructure.convert.RealmManagerConvert;
import com.github.sparkzxl.auth.infrastructure.entity.RealmManager;
import com.github.sparkzxl.auth.infrastructure.mapper.RealmManagerMapper;
import com.github.sparkzxl.auth.interfaces.dto.manager.RealmManagerSaveDTO;
import com.github.sparkzxl.core.entity.AuthUserInfo;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 领域管理员 服务实现类
 *
 * @author zhouxinlei
 * @date 2021-03-19 20:55:36
 */
@Service
public class RealmManagerServiceImpl extends SuperCacheServiceImpl<RealmManagerMapper, RealmManager> implements IRealmManagerService {

    private IRealmManagerRepository realmManagerRepository;

    @Autowired
    public void setRealmManagerRepository(IRealmManagerRepository realmManagerRepository) {
        this.realmManagerRepository = realmManagerRepository;
    }

    @Override
    public RealmManager getByAccount(String username) {
        return realmManagerRepository.selectByAccount(username);
    }

    @Override
    public AuthUserInfo<Long> getAuthUserInfo(String username) {
        RealmManager realmManager = realmManagerRepository.selectByAccount(username);
        if (ObjectUtils.isNotEmpty(realmManager)) {
            return UserDetailsServiceImpl.buildAuthUserInfo(realmManager, Lists.newArrayList("REALM_MANAGER"));
        }
        return null;
    }

    @Override
    public boolean realmManagerRegister(RealmManagerSaveDTO realmManagerSaveDTO) {
        return realmManagerRepository.saveRealmManager(RealmManagerConvert.INSTANCE.convertRealmManager(realmManagerSaveDTO));
    }

    @Override
    protected String getRegion() {
        return "realm_manager";
    }
}
