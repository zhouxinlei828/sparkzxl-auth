package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.application.service.IRealmPoolService;
import com.github.sparkzxl.auth.domain.repository.IRealmPoolRepository;
import com.github.sparkzxl.auth.infrastructure.convert.RealmPoolConvert;
import com.github.sparkzxl.auth.infrastructure.entity.RealmPool;
import com.github.sparkzxl.auth.infrastructure.mapper.RealmPoolMapper;
import com.github.sparkzxl.auth.interfaces.dto.realm.RealmPoolQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.realm.RealmPoolSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.realm.RealmPoolUpdateDTO;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.dto.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 领域池信息 服务实现类
 *
 * @author charles.zhou
 * @date 2021-02-02 16:21:08
 */
@Service
public class RealmPoolServiceImpl extends SuperCacheServiceImpl<RealmPoolMapper, RealmPool> implements IRealmPoolService {

    @Autowired
    private IRealmPoolRepository realmPoolRepository;

    @Override
    public PageInfo<RealmPool> getRealmPoolPageList(PageParams<RealmPoolQueryDTO> params) {
        return realmPoolRepository.getRealmPoolPageList(params.getPageNum(), params.getPageSize(),
                params.getModel().getRealmUserId(), params.getModel().getCode(),
                params.getModel().getName());
    }

    @Override
    public boolean saveRealmPool(RealmPoolSaveDTO realmPoolSaveDTO) {
        RealmPool realmPool = RealmPoolConvert.INSTANCE.convertRealmPool(realmPoolSaveDTO);
        return realmPoolRepository.saveRealmPool(realmPool);
    }

    @Override
    public boolean updateRealmPool(RealmPoolUpdateDTO realmPoolUpdateDTO) {
        RealmPool realmPool = RealmPoolConvert.INSTANCE.convertRealmPool(realmPoolUpdateDTO);
        return realmPoolRepository.updateRealmPool(realmPool);
    }

    @Override
    public boolean deleteRealmPool(Long realmPoolId) {
        return realmPoolRepository.deleteRealmPool(realmPoolId);
    }

    @Override
    public boolean deleteBatchRealmPool(List<Long> realmPoolIds) {
        return realmPoolRepository.deleteBatchRealmPool(realmPoolIds);
    }

    @Override
    public boolean checkRealmCode(String realmCode) {
        return count(new LambdaQueryWrapper<RealmPool>().eq(RealmPool::getCode, realmCode)) == 1;
    }

    @Override
    protected String getRegion() {
        return "realm_pool";
    }
}
