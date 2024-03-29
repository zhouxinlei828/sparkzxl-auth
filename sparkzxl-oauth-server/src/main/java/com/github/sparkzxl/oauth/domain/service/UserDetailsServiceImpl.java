package com.github.sparkzxl.oauth.domain.service;

import com.github.sparkzxl.auth.api.dto.UserDetailInfo;
import com.github.sparkzxl.core.util.ListUtils;
import com.github.sparkzxl.entity.security.AuthUserDetail;
import com.github.sparkzxl.oauth.interfaces.client.UserInfoProvider;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * description: 获取授权用户 服务实现类
 *
 * @author charles.zhou
 * @since 2020-08-03 17:16:17
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserInfoProvider userInfoProvider;

    @Autowired
    public void setUserInfoClient(UserInfoProvider userInfoProvider) {
        this.userInfoProvider = userInfoProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getAuthUserDetail(username);
    }

    public AuthUserDetail getAuthUserDetail(String username) {
        return getUserDetail(username);
    }

    private AuthUserDetail getUserDetail(String username) {
        UserDetailInfo userDetailInfo = userInfoProvider.getUserDetailInfo(username);
        if (ObjectUtils.isNotEmpty(userDetailInfo)) {
            AuthUserDetail authUserDetail = new AuthUserDetail(userDetailInfo.getId(), userDetailInfo.getAccount(),
                    userDetailInfo.getPassword(),
                    userDetailInfo.getName(),
                    AuthorityUtils.createAuthorityList(ListUtils.listToArray(userDetailInfo.getAuthorityList())));
            authUserDetail.setId(userDetailInfo.getId());
            authUserDetail.setName(userDetailInfo.getName());
            authUserDetail.setTenantId(userDetailInfo.getTenantId());
            return authUserDetail;
        }
        throw new UsernameNotFoundException("用户不存在");
    }
}
