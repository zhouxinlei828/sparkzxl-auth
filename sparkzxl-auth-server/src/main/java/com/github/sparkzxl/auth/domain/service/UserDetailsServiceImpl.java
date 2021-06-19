package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.ITenantManagerService;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.infrastructure.constant.RoleConstant;
import com.github.sparkzxl.auth.infrastructure.convert.AuthUserConvert;
import com.github.sparkzxl.auth.infrastructure.convert.TenantManagerConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.TenantManager;
import com.github.sparkzxl.auth.infrastructure.security.AuthUserDetail;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.core.entity.AuthUserInfo;
import com.github.sparkzxl.core.utils.ListUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * description: 获取授权用户 服务实现类
 *
 * @author charles.zhou
 * @date 2020-08-03 17:16:17
 */
@Service("oauthUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private IUserService authUserService;

    private ITenantManagerService tenantManagerService;

    @Autowired
    public void setAuthUserService(IUserService authUserService) {
        this.authUserService = authUserService;
    }

    @Autowired
    public void setTenantManagerService(ITenantManagerService tenantManagerService) {
        this.tenantManagerService = tenantManagerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getAuthUserDetail(username);
    }

    public AuthUserDetail<Long> getAuthUserDetail(String username) {
        TenantManager tenantManager = tenantManagerService.getByAccount(username);
        if (ObjectUtils.isNotEmpty(tenantManager)) {
            AuthUserInfo<Long> authUserInfo = buildAuthUserInfo(tenantManager, Lists.newArrayList(RoleConstant.TENANT_MANAGER_CODE, RoleConstant.USER_CODE));
            AuthUserDetail<Long> authUserDetail = new AuthUserDetail<>(tenantManager.getAccount(),
                    tenantManager.getPassword(),
                    AuthorityUtils.createAuthorityList(ListUtils.listToArray(authUserInfo.getAuthorityList())));
            authUserDetail.setId(tenantManager.getId());
            authUserDetail.setName(tenantManager.getName());
            authUserDetail.setTenantStatus(true);
            return authUserDetail;
        } else {
            AuthUser authUser = authUserService.getByAccount(username);
            if (ObjectUtils.isNotEmpty(authUser)) {
                AuthUserInfo<Long> authUserInfo = buildAuthUserInfo(authUser, authUserService.getAuthUserRoles(authUser.getId()));
                List<String> authorityList = authUserInfo.getAuthorityList();
                authorityList.add(RoleConstant.USER_CODE);
                AuthUserDetail<Long> authUserDetail = new AuthUserDetail<>(authUser.getAccount(),
                        authUser.getPassword(),
                        AuthorityUtils.createAuthorityList(ListUtils.listToArray(authorityList)));
                authUserDetail.setId(authUser.getId());
                authUserDetail.setName(authUser.getName());
                authUserDetail.setTenant(authUser.getTenantId());
                authUserDetail.setTenantStatus(false);
                BaseContextHolder.setTenant(authUser.getTenantId());
                return authUserDetail;
            }
        }
        return null;
    }

    public static AuthUserInfo<Long> buildAuthUserInfo(AuthUser authUser, List<String> authUserRoles) {
        AuthUserInfo<Long> authUserInfo = AuthUserConvert.INSTANCE.convertAuthUserInfo(authUser);
        authUserInfo.setAuthorityList(authUserRoles);
        Map<String, Object> extraInfo = Maps.newHashMap();
        extraInfo.put("org", authUser.getOrg().getData());
        extraInfo.put("station", authUser.getStation());
        extraInfo.put("mobile", authUser.getMobile());
        extraInfo.put("email", authUser.getEmail());
        extraInfo.put("education", authUser.getEducation());
        extraInfo.put("positionStatus", authUser.getPositionStatus());
        extraInfo.put("tenantStatus", false);
        authUserInfo.setExtraInfo(extraInfo);
        return authUserInfo;
    }

    public static AuthUserInfo<Long> buildAuthUserInfo(TenantManager tenantManager, List<String> authUserRoles) {
        AuthUserInfo<Long> authUserInfo = TenantManagerConvert.INSTANCE.convertAuthUserInfo(tenantManager);
        authUserInfo.setAuthorityList(authUserRoles);
        Map<String, Object> extraInfo = Maps.newHashMap();
        extraInfo.put("tenantStatus", true);
        authUserInfo.setExtraInfo(extraInfo);
        return authUserInfo;
    }
}
