package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.bean.OptionalBean;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.DesensitizedUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.api.constant.enums.SexEnum;
import com.github.sparkzxl.auth.api.dto.OrgBasicInfo;
import com.github.sparkzxl.auth.api.dto.ResourceBasicInfo;
import com.github.sparkzxl.auth.api.dto.RoleBasicInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.AuthUserBasicInfo;
import com.github.sparkzxl.auth.domain.repository.IAuthUserRepository;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.convert.AuthRoleConvert;
import com.github.sparkzxl.auth.infrastructure.convert.AuthUserConvert;
import com.github.sparkzxl.auth.infrastructure.entity.*;
import com.github.sparkzxl.auth.infrastructure.enums.AuthorityTypeEnum;
import com.github.sparkzxl.auth.infrastructure.mapper.*;
import com.github.sparkzxl.core.tree.TreeUtils;
import com.github.sparkzxl.entity.data.RemoteData;
import com.github.sparkzxl.entity.data.SuperEntity;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description：用户仓储层实现类
 *
 * @author charles.zhou
 * @date 2020/6/5 8:45 下午
 */
@Repository
@Slf4j
public class AuthUserRepository implements IAuthUserRepository {

    @Resource
    private AuthUserMapper authUserMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private AuthRoleMapper authRoleMapper;
    @Resource
    private RoleAuthorityMapper roleAuthorityMapper;
    @Resource
    private AuthResourceMapper authResourceMapper;
    @Resource
    private CoreOrgMapper coreOrgMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private Snowflake snowflake;

    @Override
    public AuthUser selectById(Long id) {
        return authUserMapper.selectById(id);
    }

    @Override
    public AuthUser selectByAccount(String account) {
        LambdaQueryWrapper<AuthUser> queryWrapper = new LambdaQueryWrapper<>();
        boolean mobile = Validator.isMobile(account);
        queryWrapper.eq(mobile, AuthUser::getMobile, account)
                .eq(!mobile, AuthUser::getAccount, account)
                .eq(AuthUser::getStatus, true);
        return authUserMapper.selectOne(queryWrapper);
    }

    @Override
    public List<String> getAuthUserPermissions(Long id) {
        return authUserMapper.getAuthUserPermissions(id);
    }

    @Override
    public List<String> getAuthUserRoles(Long id) {
        return authUserMapper.getAuthUserRoles(id);
    }

    @Override
    public void deleteUserRelation(List<Long> ids) {
        userRoleMapper.delete(new LambdaUpdateWrapper<UserRole>().in(UserRole::getUserId, ids));
    }

    @Override
    public List<AuthUser> getAuthUserList(AuthUser authUser) {
        Integer sexCode = OptionalBean.ofNullable(authUser.getSex()).getBean(SexEnum::getCode).get();
        String nationCode = OptionalBean.ofNullable(authUser.getNation()).getBean(RemoteData::getKey).get();
        Long orgId = OptionalBean.ofNullable(authUser.getOrg()).getBean(RemoteData::getKey).get();
        LambdaQueryWrapper<AuthUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeRight(StringUtils.isNotEmpty(authUser.getAccount()), AuthUser::getAccount, authUser.getAccount())
                .likeRight(StringUtils.isNotEmpty(authUser.getName()), AuthUser::getName, authUser.getName())
                .eq(ObjectUtils.isNotEmpty(authUser.getStatus()), AuthUser::getStatus, authUser.getStatus())
                .eq(ObjectUtils.isNotEmpty(authUser.getStatus()), AuthUser::getStatus, authUser.getStatus())
                .eq(ObjectUtils.isNotEmpty(sexCode), AuthUser::getSex, sexCode)
                .eq(StringUtils.isNotEmpty(nationCode), AuthUser::getNation, nationCode)
                .eq(ObjectUtils.isNotEmpty(orgId), AuthUser::getOrg, orgId);
        List<AuthUser> authUsers = authUserMapper.selectList(queryWrapper);
        authUsers.forEach(user -> user.setPassword(DesensitizedUtil.password(user.getPassword())));
        return authUsers;
    }

    private OrgBasicInfo buildOrgBasicInfo(CoreOrg coreOrg) {
        OrgBasicInfo orgBasicInfo = new OrgBasicInfo();
        orgBasicInfo.setId(coreOrg.getId());
        orgBasicInfo.setLabel(coreOrg.getLabel());
        orgBasicInfo.setParentId(coreOrg.getParentId());
        orgBasicInfo.setSortNumber(coreOrg.getSortNumber());
        return orgBasicInfo;
    }

    @Override
    public boolean deleteAuthUser(List<Long> ids) {
        authUserMapper.deleteBatchIds(ids);
        deleteUserRelation(ids);
        return true;
    }

    @Override
    public boolean saveAuthUser(AuthUser authUser) {
        String password = passwordEncoder.encode(authUser.getPassword());
        authUser.setPassword(password);
        return authUserMapper.insert(authUser) == 1;
    }

    @Override
    public boolean updateAuthUser(AuthUser authUser) {
        LambdaUpdateWrapper<AuthUser> updateWrapper = new LambdaUpdateWrapper<>();
        if (MapUtils.isEmpty(authUser.getExtendInfo())) {
            updateWrapper.set(AuthUser::getExtendInfo, null);
        }
        updateWrapper.eq(SuperEntity::getId, authUser.getId());
        return authUserMapper.update(authUser, updateWrapper) == 1;
    }

    @Override
    public void deleteOrgIds(List<Long> ids) {
        LambdaUpdateWrapper<AuthUser> userUpdateWrapper = new LambdaUpdateWrapper<>();
        userUpdateWrapper.set(AuthUser::getOrg, null);
        userUpdateWrapper.in(AuthUser::getOrg, ids);
        authUserMapper.update(null, userUpdateWrapper);
    }

    @Override
    public boolean updateOrgUser(Long orgId, List<Long> userIds) {
        if (CollectionUtils.isNotEmpty(userIds)) {
            userIds.forEach(userId -> {
                AuthUser authUser = new AuthUser();
                authUser.setId(userId);
                authUser.setOrg(new RemoteData<>(orgId, null));
                authUserMapper.updateById(authUser);
            });
        } else {
            LambdaUpdateWrapper<AuthUser> userUpdateWrapper = new LambdaUpdateWrapper<>();
            userUpdateWrapper.set(AuthUser::getOrg, null);
            userUpdateWrapper.eq(AuthUser::getOrg, orgId);
            authUserMapper.update(null, userUpdateWrapper);
        }
        return true;
    }

    @Override
    public AuthUserBasicInfo getAuthUserBasicInfo(Long userId) {
        AuthUser authUser = authUserMapper.getById(userId);
        return buildAuthUserBasicInfo(authUser);
    }

    @Override
    public AuthUserBasicInfo getUserByUsername(String username) {
        AuthUser authUser = authUserMapper.getByUsername(username);
        return buildAuthUserBasicInfo(authUser);
    }

    private AuthUserBasicInfo buildAuthUserBasicInfo(AuthUser authUser) {
        AuthUserBasicInfo authUserBasicInfo = AuthUserConvert.INSTANCE.convertAuthUserBasicInfo(authUser);
        List<OrgBasicInfo> orgTreeList = CollUtil.newArrayList();
        CoreOrg org = OptionalBean.ofNullable(authUser.getOrg().getData()).get();
        if (ObjectUtils.isNotEmpty(org)) {
            orgTreeList.add(buildOrgBasicInfo(org));
            if (org.getParentId() != 0) {
                CoreOrg coreOrg = coreOrgMapper.selectById(org.getParentId());
                orgTreeList.add(buildOrgBasicInfo(coreOrg));
                authUserBasicInfo.setOrgName(coreOrg.getLabel().concat("-").concat(org.getLabel()));
            } else {
                authUserBasicInfo.setOrgName(org.getLabel());
            }
            authUserBasicInfo.setOrg(TreeUtils.buildTree(orgTreeList));
        }

        List<Long> roleIds =
                userRoleMapper.selectList(new LambdaUpdateWrapper<UserRole>().eq(UserRole::getUserId, authUser.getId())).stream().map(UserRole::getRoleId)
                        .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(roleIds)) {
            List<AuthRole> roleList = authRoleMapper.selectBatchIds(roleIds);
            List<RoleBasicInfo> roleBasicInfos = AuthRoleConvert.INSTANCE.convertRoleBasicInfo(roleList);
            RoleBasicInfo roleBasicInfo = new RoleBasicInfo();
            roleBasicInfo.setId(snowflake.nextId());
            roleBasicInfo.setCode(BizConstant.USER_CODE);
            roleBasicInfo.setName("普通用户");
            roleBasicInfos.add(roleBasicInfo);
            authUserBasicInfo.setRoleList(roleBasicInfos);
            LambdaQueryWrapper<RoleAuthority> roleAuthorityLambdaQueryWrapper = new LambdaQueryWrapper<RoleAuthority>()
                    .in(RoleAuthority::getRoleId, roleIds)
                    .eq(RoleAuthority::getAuthorityType, AuthorityTypeEnum.RESOURCE.name());
            List<RoleAuthority> roleAuthorities =
                    roleAuthorityMapper.selectList(roleAuthorityLambdaQueryWrapper);
            List<Long> authorityIds = roleAuthorities.stream().distinct().map(RoleAuthority::getAuthorityId).collect(Collectors.toList());
            Map<Long, Long> roleAuthorityIdMap =
                    roleAuthorities.stream().collect(Collectors.toMap(RoleAuthority::getAuthorityId, RoleAuthority::getRoleId));
            List<ResourceBasicInfo> resourceBasicInfos = Lists.newArrayList();
            if (CollectionUtils.isNotEmpty(authorityIds)) {
                // 获取用户资源列表
                List<AuthResource> resourceList = authResourceMapper.selectBatchIds(authorityIds);
                if (CollectionUtils.isNotEmpty(resourceList)) {
                    resourceList.forEach(resource -> {
                        ResourceBasicInfo resourceBasicInfo = new ResourceBasicInfo();
                        resourceBasicInfo.setCode(resource.getCode());
                        resourceBasicInfo.setName(resource.getName());
                        resourceBasicInfo.setRoleId(roleAuthorityIdMap.get(resource.getId()));
                        resourceBasicInfos.add(resourceBasicInfo);
                    });
                }
            }
            authUserBasicInfo.setResourceList(resourceBasicInfos);
        } else {
            RoleBasicInfo roleBasicInfo = new RoleBasicInfo();
            roleBasicInfo.setId(snowflake.nextId());
            roleBasicInfo.setCode(BizConstant.USER_CODE);
            roleBasicInfo.setName("普通用户");
            List<RoleBasicInfo> roleBasicInfos = Lists.newArrayList(roleBasicInfo);
            authUserBasicInfo.setRoleList(roleBasicInfos);
        }
        return authUserBasicInfo;
    }
}
