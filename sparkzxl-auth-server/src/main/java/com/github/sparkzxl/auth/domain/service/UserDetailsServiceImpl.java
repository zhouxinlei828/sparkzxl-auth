package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IRealmManagerService;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.infrastructure.convert.AuthUserConvert;
import com.github.sparkzxl.auth.infrastructure.convert.RealmManagerConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.RealmManager;
import com.github.sparkzxl.auth.infrastructure.security.AuthUserDetail;
import com.github.sparkzxl.core.context.BaseContextHandler;
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

    private IRealmManagerService realmManagerService;

    @Autowired
    public void setAuthUserService(IUserService authUserService) {
        this.authUserService = authUserService;
    }

    @Autowired
    public void setRealmManagerService(IRealmManagerService realmManagerService) {
        this.realmManagerService = realmManagerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getAuthUserDetail(username);
    }

    public AuthUserDetail<Long> getAuthUserDetail(String username) {
        RealmManager realmManager = realmManagerService.getByAccount(username);
        if (ObjectUtils.isNotEmpty(realmManager)) {
            AuthUserInfo<Long> authUserInfo = buildAuthUserInfo(realmManager, Lists.newArrayList("role_realm"));
            AuthUserDetail<Long> authUserDetail = new AuthUserDetail<>(realmManager.getAccount(),
                    realmManager.getPassword(),
                    AuthorityUtils.createAuthorityList(ListUtils.listToArray(authUserInfo.getAuthorityList())));
            authUserDetail.setId(realmManager.getId());
            authUserDetail.setName(realmManager.getName());
            authUserDetail.setRealmStatus(true);
            return authUserDetail;
        } else {
            AuthUser authUser = authUserService.getByAccount(username);
            if (ObjectUtils.isNotEmpty(authUser)) {
                AuthUserInfo<Long> authUserInfo = buildAuthUserInfo(authUser, authUserService.getAuthUserRoles(authUser.getId()));
                AuthUserDetail<Long> authUserDetail = new AuthUserDetail<>(authUser.getAccount(),
                        authUser.getPassword(),
                        AuthorityUtils.createAuthorityList(ListUtils.listToArray(authUserInfo.getAuthorityList())));
                authUserDetail.setId(authUser.getId());
                authUserDetail.setName(authUser.getName());
                authUserDetail.setRealm(authUser.getTenantCode());
                authUserDetail.setRealmStatus(authUser.getRealmStatus());
                BaseContextHandler.setRealm(authUser.getTenantCode());
                return authUserDetail;
            }
        }
        return null;
    }

    static AuthUserInfo<Long> buildAuthUserInfo(AuthUser authUser, List<String> authUserRoles) {
        AuthUserInfo<Long> authUserInfo = AuthUserConvert.INSTANCE.convertAuthUserInfo(authUser);
        authUserInfo.setAuthorityList(authUserRoles);
        Map<String, Object> extraInfo = Maps.newHashMap();
        extraInfo.put("org", authUser.getOrg().getData());
        extraInfo.put("station", authUser.getStation());
        extraInfo.put("mobile", authUser.getMobile());
        extraInfo.put("email", authUser.getEmail());
        extraInfo.put("education", authUser.getEducation());
        extraInfo.put("positionStatus", authUser.getPositionStatus());
        extraInfo.put("realmStatus", authUser.getRealmStatus() != null && authUser.getRealmStatus());
        authUserInfo.setExtraInfo(extraInfo);
        return authUserInfo;
    }

    static AuthUserInfo<Long> buildAuthUserInfo(RealmManager realmManager, List<String> authUserRoles) {
        AuthUserInfo<Long> authUserInfo = RealmManagerConvert.INSTANCE.convertAuthUserInfo(realmManager);
        authUserInfo.setAuthorityList(authUserRoles);
        Map<String, Object> extraInfo = Maps.newHashMap();
        extraInfo.put("realmStatus", true);
        authUserInfo.setExtraInfo(extraInfo);
        return authUserInfo;
    }
}
