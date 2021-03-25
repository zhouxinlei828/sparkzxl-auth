package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.UserCount;
import com.github.sparkzxl.auth.domain.repository.*;
import com.github.sparkzxl.auth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.auth.infrastructure.entity.AuthMenu;
import com.github.sparkzxl.auth.infrastructure.entity.RealmPool;
import com.github.sparkzxl.auth.infrastructure.mapper.*;
import com.github.sparkzxl.core.context.BaseContextHandler;
import com.github.sparkzxl.database.utils.PageInfoUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 领域池仓储实现类
 *
 * @author charles.zhou
 * @date 2021-02-14 10:13:48
 */
@Repository
public class RealmPoolRepository implements IRealmPoolRepository {

    @Autowired
    private RealmPoolMapper realmPoolMapper;
    @Autowired
    private IAuthUserRepository authUserRepository;
    @Autowired
    private IAuthRoleRepository authRoleRepository;
    @Autowired
    private IAuthMenuRepository authMenuRepository;
    @Autowired
    private IAuthResourceRepository resourceRepository;
    @Autowired
    private AuthApplicationMapper applicationMapper;
    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;
    @Autowired
    private CoreStationMapper stationMapper;
    @Autowired
    private CoreOrgMapper orgMapper;
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private DictionaryItemMapper dictionaryItemMapper;

    @Override
    public PageInfo<RealmPool> getRealmPoolPageList(int pageNum, int pageSize, Long realmUserId, String code, String name) {
        LambdaQueryWrapper<RealmPool> tenantLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(code)) {
            tenantLambdaQueryWrapper.eq(RealmPool::getCode, code);
        }
        if (StringUtils.isNotEmpty(name)) {
            tenantLambdaQueryWrapper.likeLeft(RealmPool::getName, name);
        }
        tenantLambdaQueryWrapper.eq(RealmPool::getRealmUserId, realmUserId);
        tenantLambdaQueryWrapper.orderByAsc(RealmPool::getCode);
        PageHelper.startPage(pageNum, pageSize);
        List<RealmPool> tenantList = realmPoolMapper.selectList(tenantLambdaQueryWrapper);
        PageInfo<RealmPool> realmPoolPageInfo = PageInfoUtils.pageInfo(tenantList);
        List<RealmPool> realmPoolList = realmPoolPageInfo.getList();
        if (CollectionUtils.isNotEmpty(realmPoolList)) {
            List<String> realmCodeList = realmPoolList.stream().map(RealmPool::getCode).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(realmCodeList)) {
                List<UserCount> userCounts = authUserRepository.userCount(realmCodeList);
                if (CollectionUtils.isNotEmpty(userCounts)) {
                    Map<String, Integer> userCountsMap = userCounts.stream().collect(Collectors.toMap(UserCount::getRealmCode,
                            UserCount::getCount));
                    realmPoolList.forEach(realmPool -> {
                        Integer userCount = userCountsMap.get(realmPool.getCode());
                        if (ObjectUtils.isNotEmpty(userCount)) {
                            realmPool.setUserCount(userCount);
                        }
                    });
                }
                realmPoolPageInfo.setList(realmPoolList);
            }
        }
        return realmPoolPageInfo;
    }

    @Override
    public List<RealmPool> getRealmPoolList(Long realmUserId) {
        LambdaQueryWrapper<RealmPool> realmPoolLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtils.isNotEmpty(realmUserId)) {
            realmPoolLambdaQueryWrapper.eq(RealmPool::getRealmUserId, realmUserId);
        }
        return realmPoolMapper.selectList(realmPoolLambdaQueryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRealmPool(RealmPool realmPool) {
        String realmCode = IdUtil.objectId();
        Long userId = BaseContextHandler.getUserId(Long.TYPE);
        realmPool.setRealmUserId(userId);
        realmPool.setCode(realmCode);
        realmPoolMapper.insert(realmPool);
        initRealmPoolData(realmCode);
        return true;
    }

    public void initRealmPoolData(String realmCode) {
        BaseContextHandler.setRealm(realmCode);
        initMenuData(realmCode);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void initMenuData(String realmCode) {
        String menuJsonStr = ResourceUtil.readUtf8Str("menu.json");
        List<AuthMenu> authMenus = JSONArray.parseArray(menuJsonStr, AuthMenu.class);
        authMenuRepository.saveAuthMenus(authMenus, realmCode);
    }

    @Override
    public boolean updateRealmPool(RealmPool tenant) {
        return realmPoolMapper.updateById(tenant) != 0;
    }

    @Override
    public boolean deleteRealmPool(Long realmPoolId) {
        RealmPool realmPool = realmPoolMapper.selectById(realmPoolId);
        String realmCode = realmPool.getCode();
        authUserRepository.deleteRealmPoolUser(realmCode);
        authRoleRepository.deleteAuthRole(realmCode);
        resourceRepository.deleteRealmPoolResource(realmCode);
        authMenuRepository.deleteRealmPoolMenu(realmCode);
        List<AuthApplication> applicationList = applicationMapper.selectList(new LambdaQueryWrapper<AuthApplication>()
                .eq(AuthApplication::getRealmCode, realmCode));
        if (CollectionUtils.isNotEmpty(applicationList)) {
            List<String> clientIdList = applicationList.stream().map(AuthApplication::getClientId).collect(Collectors.toList());
            oauthClientDetailsMapper.deleteBatchIds(clientIdList);
        }
        applicationMapper.deleteApplicationByCode(realmCode);
        stationMapper.deleteTenantStation(realmCode);
        orgMapper.deleteTenantOrg(realmCode);
        dictionaryMapper.deleteTenantDictionary(realmCode);
        dictionaryItemMapper.deleteTenantDictionaryItem(realmCode);
        return realmPoolMapper.deleteById(realmPoolId) != 0;
    }

    @Override
    public boolean deleteBatchRealmPool(List<Long> realmPoolIds) {
        if (CollectionUtils.isNotEmpty(realmPoolIds)) {
            realmPoolIds.forEach(this::deleteRealmPool);
        }
        return true;
    }
}
