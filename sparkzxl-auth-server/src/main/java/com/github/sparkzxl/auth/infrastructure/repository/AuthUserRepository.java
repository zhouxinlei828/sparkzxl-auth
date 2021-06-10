package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.domain.model.aggregates.*;
import com.github.sparkzxl.auth.domain.repository.IAuthUserRepository;
import com.github.sparkzxl.auth.infrastructure.constant.RoleConstant;
import com.github.sparkzxl.auth.infrastructure.convert.AuthRoleConvert;
import com.github.sparkzxl.auth.infrastructure.convert.AuthUserConvert;
import com.github.sparkzxl.auth.infrastructure.entity.*;
import com.github.sparkzxl.auth.infrastructure.mapper.*;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.core.tree.TreeUtils;
import com.github.sparkzxl.database.echo.annonation.EchoResult;
import com.github.sparkzxl.database.entity.RemoteData;
import com.github.sparkzxl.database.entity.SuperEntity;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description：用户仓储层实现类
 *
 * @author charles.zhou
 * @date 2020/6/5 8:45 下午
 */
@RequiredArgsConstructor
@Repository
@Slf4j
public class AuthUserRepository implements IAuthUserRepository {

    private final AuthUserMapper authUserMapper;
    private final UserRoleMapper userRoleMapper;
    private final AuthRoleMapper authRoleMapper;
    private final RoleAuthorityMapper roleAuthorityMapper;
    private final AuthResourceMapper authResourceMapper;
    private final CoreOrgMapper coreOrgMapper;
    private final PasswordEncoder passwordEncoder;
    private final Snowflake snowflake;

    @Override
    public AuthUser selectById(Long id) {
        return authUserMapper.selectById(id);
    }

    @Override
    @EchoResult
    public AuthUser selectByAccount(String account) {
        QueryWrapper<AuthUser> queryWrapper = new QueryWrapper<>();
        boolean mobile = Validator.isMobile(account);
        if (mobile) {
            queryWrapper.lambda().eq(AuthUser::getMobile, account);
        } else {
            queryWrapper.lambda().eq(AuthUser::getAccount, account);
        }
        queryWrapper.lambda().eq(AuthUser::getStatus, true);
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
    @EchoResult
    public List<AuthUser> getAuthUserList(AuthUser authUser, List<Long> userIdList) {
        LambdaQueryWrapper<AuthUser> queryWrapper = new LambdaQueryWrapper<>();
        if (CollectionUtils.isNotEmpty(userIdList)) {
            queryWrapper.in(SuperEntity::getId, userIdList);
        }
        if (StringUtils.isNotEmpty(authUser.getAccount())) {
            queryWrapper.like(AuthUser::getAccount, authUser.getAccount());
        }
        if (StringUtils.isNotEmpty(authUser.getName())) {
            queryWrapper.like(AuthUser::getName, authUser.getName());
        }
        if (ObjectUtils.isNotEmpty(authUser.getStatus())) {
            queryWrapper.eq(AuthUser::getStatus, authUser.getStatus());
        }
        if (ObjectUtils.isNotEmpty(authUser.getSex()) && ObjectUtils.isNotEmpty(authUser.getSex().getCode())) {
            queryWrapper.eq(AuthUser::getSex, authUser.getSex());
        }
        if (ObjectUtils.isNotEmpty(authUser.getNation()) && StringUtils.isNotEmpty(authUser.getNation().getKey())) {
            queryWrapper.eq(AuthUser::getNation, authUser.getNation());
        }
        if (ObjectUtils.isNotEmpty(authUser.getOrg()) && ObjectUtils.isNotEmpty(authUser.getOrg().getKey())) {
            queryWrapper.eq(AuthUser::getOrg, authUser.getOrg().getKey());
        }
        String realmCode = BaseContextHolder.getRealm();
        if (StringUtils.isNotEmpty(realmCode)) {
            queryWrapper.like(AuthUser::getRealmCode, realmCode);
        }
        return authUserMapper.selectList(queryWrapper);
    }

    @Override
    public AuthUserBasicInfo getAuthUserBasicInfo(Long userId) {
        AuthUser authUser = authUserMapper.getById(userId);
        AuthUserBasicInfo authUserBasicInfo = AuthUserConvert.INSTANCE.convertAuthUserBasicInfo(authUser);
        authUserBasicInfo.setRealmStatus(false);
        RemoteData<Long, CoreOrg> org = authUser.getOrg();
        List<OrgBasicInfo> orgTreeList = CollUtil.newArrayList();
        if (ObjectUtils.isNotEmpty(org)) {
            CoreOrg data = org.getData();
            if (ObjectUtils.isNotEmpty(data)) {
                orgTreeList.add(buildOrgBasicInfo(data));
                if (data.getParentId() != 0) {
                    CoreOrg coreOrg = coreOrgMapper.selectById(data.getParentId());
                    orgTreeList.add(buildOrgBasicInfo(coreOrg));
                    authUserBasicInfo.setOrgName(coreOrg.getLabel().concat("-").concat(data.getLabel()));
                } else {
                    authUserBasicInfo.setOrgName(data.getLabel());
                }
                authUserBasicInfo.setOrg(TreeUtils.buildTree(orgTreeList));
            }
        }

        List<Long> roleIds =
                userRoleMapper.selectList(new LambdaUpdateWrapper<UserRole>().eq(UserRole::getUserId, userId)).stream().map(UserRole::getRoleId)
                        .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(roleIds)) {
            List<AuthRole> roleList = authRoleMapper.selectBatchIds(roleIds);
            List<RoleBasicInfo> roleBasicInfos = AuthRoleConvert.INSTANCE.convertRoleBasicInfo(roleList);
            RoleBasicInfo roleBasicInfo = new RoleBasicInfo();
            roleBasicInfo.setId(snowflake.nextId());
            roleBasicInfo.setCode(RoleConstant.USER_CODE);
            roleBasicInfo.setName("普通用户");
            roleBasicInfos.add(roleBasicInfo);
            authUserBasicInfo.setRoleBasicInfos(roleBasicInfos);
            List<RoleAuthority> roleAuthorities =
                    roleAuthorityMapper.selectList(new LambdaQueryWrapper<RoleAuthority>().in(RoleAuthority::getRoleId, roleIds)
                            .eq(RoleAuthority::getAuthorityType, "RESOURCE")
                            .groupBy(RoleAuthority::getAuthorityId, RoleAuthority::getRoleId));
            List<Long> authorityIds = roleAuthorities.stream().map(RoleAuthority::getAuthorityId).collect(Collectors.toList());
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
            authUserBasicInfo.setResourceBasicInfos(resourceBasicInfos);
        } else {
            RoleBasicInfo roleBasicInfo = new RoleBasicInfo();
            roleBasicInfo.setId(snowflake.nextId());
            roleBasicInfo.setCode(RoleConstant.USER_CODE);
            roleBasicInfo.setName("普通用户");
            List<RoleBasicInfo> roleBasicInfos = Lists.newArrayList(roleBasicInfo);
            authUserBasicInfo.setRoleBasicInfos(roleBasicInfos);
        }
        return authUserBasicInfo;
    }


    private OrgBasicInfo buildOrgBasicInfo(CoreOrg coreOrg) {
        OrgBasicInfo orgBasicInfo = new OrgBasicInfo();
        orgBasicInfo.setId(coreOrg.getId());
        orgBasicInfo.setLabel(coreOrg.getLabel());
        orgBasicInfo.setParentId(coreOrg.getParentId());
        orgBasicInfo.setSortValue(coreOrg.getSortValue());
        return orgBasicInfo;
    }

    @Override
    public void saveAuthUserInfo(AuthUser authUser) {
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        authUserMapper.insert(authUser);
    }

    @Override
    public void deleteRealmPoolUser(String realmCode) {
        authUserMapper.deleteRealmPoolUser(realmCode);
    }

    @Override
    public boolean deleteAuthUser(List<Long> ids) {
        authUserMapper.deleteBatchIds(ids);
        deleteUserRelation(ids);
        return true;
    }

    @Override
    public List<UserCount> userCount(List<String> realmCodeList) {
        return authUserMapper.userCount(realmCodeList);
    }

    @Override
    public boolean saveAuthUser(AuthUser authUser) {
        String password = passwordEncoder.encode(authUser.getPassword());
        authUser.setPassword(password);
        String realmCode = BaseContextHolder.getRealm();
        authUser.setRealmCode(realmCode);
        return authUserMapper.insert(authUser) == 1;
    }

    @Override
    public boolean updateAuthUser(AuthUser authUser) {
        return authUserMapper.updateById(authUser) == 1;
    }
}
