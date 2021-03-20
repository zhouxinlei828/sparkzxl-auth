package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.io.resource.ResourceUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.UserCount;
import com.github.sparkzxl.auth.domain.repository.*;
import com.github.sparkzxl.auth.infrastructure.entity.*;
import com.github.sparkzxl.auth.infrastructure.enums.SexEnum;
import com.github.sparkzxl.auth.infrastructure.mapper.*;
import com.github.sparkzxl.core.context.BaseContextHandler;
import com.github.sparkzxl.database.entity.SuperEntity;
import com.github.sparkzxl.database.utils.PageInfoUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
    private IIdSegmentRepository segmentRepository;
    @Autowired
    private IAuthUserRepository authUserRepository;
    @Autowired
    private IAuthRoleRepository authRoleRepository;
    @Autowired
    private IAuthMenuRepository authMenuRepository;
    @Autowired
    private IAuthResourceRepository resourceRepository;
    @Autowired
    private IUserRoleRepository userRoleRepository;
    @Autowired
    private IRoleAuthorityRepository roleAuthorityRepository;
    @Autowired
    private AuthApplicationMapper tenantClientMapper;
    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;
    @Autowired
    private CoreStationMapper stationMapper;
    @Autowired
    private CoreOrgMapper orgMapper;
    @Autowired
    private CommonDictionaryMapper dictionaryMapper;
    @Autowired
    private CommonDictionaryItemMapper dictionaryItemMapper;

    @Override
    public PageInfo<RealmPool> getRealmPoolPageList(int pageNum, int pageSize, String code, String name) {
        LambdaQueryWrapper<RealmPool> tenantLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(code)) {
            tenantLambdaQueryWrapper.eq(RealmPool::getCode, code);
        }
        if (StringUtils.isNotEmpty(name)) {
            tenantLambdaQueryWrapper.likeLeft(RealmPool::getName, name);
        }
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
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRealmPool(RealmPool realmPool) {
        String realmCode = segmentRepository.getIdSegment("realm_code").toString();
        realmPool.setCode(realmCode);
        realmPoolMapper.insert(realmPool);
        initTenantData(realmCode);
        return true;
    }

    public void initTenantData(String realmCode) {
        BaseContextHandler.setRealm(realmCode);
        // 初始化管理员账户
        AuthUser authUser = new AuthUser();
        authUser.setAccount("admin");
        authUser.setPassword("123456");
        authUser.setName("管理员");
        authUser.setRealmCode(realmCode);
        authUser.setSex(SexEnum.MAN);
        authUser.setStatus(true);
        authUserRepository.saveAuthUserInfo(authUser);
        Long userId = authUser.getId();
        // 初始化管理员角色
        AuthRole authRole = new AuthRole();
        authRole.setCode("ADMIN");
        authRole.setName("管理员");
        authRole.setDescribe("内置管理员");
        authRole.setReadonly(true);
        authRole.setDsType("ALL");
        authRole.setStatus(true);
        authRoleRepository.saveRole(authRole);
        Long roleId = authRole.getId();
        userRoleRepository.saveAuthRoleUser(roleId, Lists.newArrayList(userId));
        // 初始化菜单资源
        initMenuData(realmCode);
        List<AuthMenu> authMenuList = authMenuRepository.findAuthMenuList();
        Set<Long> menuIds = authMenuList.stream().map(SuperEntity::getId).collect(Collectors.toSet());
        List<AuthResource> authResources = resourceRepository.authResourceList();
        Set<Long> resourceIds = authResources.stream().map(SuperEntity::getId).collect(Collectors.toSet());
        roleAuthorityRepository.saveRoleAuthorityBatch(roleId, resourceIds, menuIds);
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
        authUserRepository.deleteTenantUser(realmCode);
        authRoleRepository.deleteAuthRole(realmCode);
        resourceRepository.deleteTenantResource(realmCode);
        authMenuRepository.deleteTenantMenu(realmCode);
        List<AuthApplication> tenantClientList = tenantClientMapper.selectList(new LambdaQueryWrapper<AuthApplication>()
                .eq(AuthApplication::getRealmCode, realmCode));
        if (CollectionUtils.isNotEmpty(tenantClientList)) {
            List<String> clientIdList = tenantClientList.stream().map(AuthApplication::getClientId).collect(Collectors.toList());
            oauthClientDetailsMapper.deleteBatchIds(clientIdList);
        }
        tenantClientMapper.deleteTenantClient(realmCode);
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
