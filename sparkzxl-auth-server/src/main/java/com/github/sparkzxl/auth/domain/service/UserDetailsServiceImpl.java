package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.ITenantManagerService;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.infrastructure.constant.RoleConstant;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.TenantManager;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.core.utils.ListUtils;
import com.github.sparkzxl.entity.security.AuthUserDetail;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            ArrayList<String> authorityList = Lists.newArrayList(RoleConstant.TENANT_MANAGER_CODE, RoleConstant.USER_CODE);
            AuthUserDetail<Long> authUserDetail = new AuthUserDetail<>(tenantManager.getAccount(),
                    tenantManager.getPassword(),
                    AuthorityUtils.createAuthorityList(ListUtils.listToArray(authorityList)));
            authUserDetail.setId(tenantManager.getId());
            authUserDetail.setName(tenantManager.getName());
            authUserDetail.setTenantStatus(true);
            return authUserDetail;
        } else {
            return getUserDetail(username);
        }
    }

    private AuthUserDetail<Long> getUserDetail(String username) {
        AuthUser authUser = authUserService.getByAccount(username);
        if (ObjectUtils.isNotEmpty(authUser)) {
            List<String> authUserRoles = authUserService.getAuthUserRoles(authUser.getId());
            authUserRoles.add(RoleConstant.USER_CODE);
            AuthUserDetail<Long> authUserDetail = new AuthUserDetail<>(authUser.getAccount(),
                    authUser.getPassword(),
                    AuthorityUtils.createAuthorityList(ListUtils.listToArray(authUserRoles)));
            authUserDetail.setId(authUser.getId());
            authUserDetail.setName(authUser.getName());
            authUserDetail.setTenant(authUser.getTenantId());
            authUserDetail.setTenantStatus(false);
            BaseContextHolder.setTenant(authUser.getTenantId());
            return authUserDetail;
        }
        return null;
    }
}
