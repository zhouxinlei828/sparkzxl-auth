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
import com.github.sparkzxl.auth.infrastructure.entity.TenantPool;
import com.github.sparkzxl.auth.infrastructure.mapper.*;
import com.github.sparkzxl.core.context.BaseContextHolder;
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
 * description: 租户池仓储实现类
 *
 * @author charles.zhou
 * @date 2021-02-14 10:13:48
 */
@Repository
public class TenantPoolRepository implements ITenantPoolRepository {

    @Autowired
    private TenantPoolMapper TenantPoolMapper;
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
        List<TenantPool> tenantList = TenantPoolMapper.selectList(tenantLambdaQueryWrapper);
        PageInfo<TenantPool> TenantPoolPageInfo = PageInfoUtils.pageInfo(tenantList);
        List<TenantPool> TenantPoolList = TenantPoolPageInfo.getList();
        if (CollectionUtils.isNotEmpty(TenantPoolList)) {
            List<String> tenantIdList = TenantPoolList.stream().map(TenantPool::getCode).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(tenantIdList)) {
                List<UserCount> userCounts = authUserRepository.userCount(tenantIdList);
                if (CollectionUtils.isNotEmpty(userCounts)) {
                    Map<String, Integer> userCountsMap = userCounts.stream().collect(Collectors.toMap(UserCount::getTenantId,
                            UserCount::getCount));
                    TenantPoolList.forEach(TenantPool -> {
                        Integer userCount = userCountsMap.get(TenantPool.getCode());
                        if (ObjectUtils.isNotEmpty(userCount)) {
                            TenantPool.setUserCount(userCount);
                        }
                    });
                }
                TenantPoolPageInfo.setList(TenantPoolList);
            }
        }
        return TenantPoolPageInfo;
    }

    @Override
    public List<TenantPool> getTenantPoolList(Long tenantUserId) {
        LambdaQueryWrapper<TenantPool> TenantPoolLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtils.isNotEmpty(tenantUserId)) {
            TenantPoolLambdaQueryWrapper.eq(TenantPool::getTenantUserId, tenantUserId);
        }
        return TenantPoolMapper.selectList(TenantPoolLambdaQueryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveTenantPool(TenantPool tenantPool) {
        String tenantId = IdUtil.objectId();
        Long userId = BaseContextHolder.getUserId(Long.TYPE);
        tenantPool.setTenantUserId(userId);
        tenantPool.setCode(tenantId);
        TenantPoolMapper.insert(tenantPool);
        initTenantPoolData(tenantId);
        return true;
    }

    public void initTenantPoolData(String tenantId) {
        BaseContextHolder.setTenant(tenantId);
        initMenuData(tenantId);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void initMenuData(String tenantId) {
        String menuJsonStr = ResourceUtil.readUtf8Str("menu.json");
        List<AuthMenu> authMenus = JSONArray.parseArray(menuJsonStr, AuthMenu.class);
        authMenuRepository.saveAuthMenus(authMenus, tenantId);
    }

    @Override
    public boolean updateTenantPool(TenantPool tenant) {
        return TenantPoolMapper.updateById(tenant) != 0;
    }

    @Override
    public boolean deleteTenantPool(Long tenantPoolId) {
        TenantPool tenantPool = TenantPoolMapper.selectById(tenantPoolId);
        String tenantId = tenantPool.getCode();
        authUserRepository.deleteTenantPoolUser(tenantId);
        authRoleRepository.deleteAuthRole(tenantId);
        resourceRepository.deleteTenantPoolResource(tenantId);
        authMenuRepository.deleteTenantPoolMenu(tenantId);
        List<AuthApplication> applicationList = applicationMapper.selectList(new LambdaQueryWrapper<AuthApplication>()
                .eq(AuthApplication::getTenantId, tenantId));
        if (CollectionUtils.isNotEmpty(applicationList)) {
            List<String> clientIdList = applicationList.stream().map(AuthApplication::getClientId).collect(Collectors.toList());
            oauthClientDetailsMapper.deleteBatchIds(clientIdList);
        }
        applicationMapper.deleteApplicationByCode(tenantId);
        stationMapper.deleteTenantStation(tenantId);
        orgMapper.deleteTenantOrg(tenantId);
        dictionaryMapper.deleteTenantDictionary(tenantId);
        dictionaryItemMapper.deleteTenantDictionaryItem(tenantId);
        return TenantPoolMapper.deleteById(tenantPoolId) != 0;
    }

    @Override
    public boolean deleteBatchTenantPool(List<Long> tenantPoolIds) {
        if (CollectionUtils.isNotEmpty(tenantPoolIds)) {
            tenantPoolIds.forEach(this::deleteTenantPool);
        }
        return true;
    }
}
