package com.github.sparkzxl.oauth.infrastructure.security.logout;

import com.github.sparkzxl.auth.api.dto.UserDetail;
import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.core.context.RequestLocalContextHolder;
import com.github.sparkzxl.core.util.HttpRequestUtils;
import com.github.sparkzxl.core.util.KeyGeneratorUtil;
import com.github.sparkzxl.core.util.RequestContextHolderUtils;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.oauth.interfaces.client.UserInfoProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * description: 退出登录成功处理
 *
 * @author charles.zhou
 */
@Component
@Slf4j
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {

    private TokenStore tokenStore;
    private UserInfoProvider userInfoProvider;
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setTokenStore(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Autowired
    public void setUserInfoClient(UserInfoProvider userInfoProvider) {
        this.userInfoProvider = userInfoProvider;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        String token = httpServletRequest.getHeader("token");
        RequestLocalContextHolder.setTenant(RequestContextHolderUtils.getHeader(BaseContextConstants.TENANT_ID));
        log.info("退出登录成功：{}", token);
        token = StringUtils.removeStartIgnoreCase(token, BaseContextConstants.BEARER_TOKEN);
        if (token != null) {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
            if (accessToken != null) {
                tokenStore.removeAccessToken(accessToken);
                tokenStore.removeRefreshToken(accessToken.getRefreshToken());
                Map<String, Object> additionalInformation = accessToken.getAdditionalInformation();
                String username = (String) additionalInformation.get("username");
                AuthUserInfo<UserDetail> authUserInfo = userInfoProvider.getUserDetailInfo(username);
                String authUserInfoKey = KeyGeneratorUtil.generateKey(BaseContextConstants.AUTH_USER_TOKEN, authUserInfo.getId());
                redisTemplate.opsForHash().delete(authUserInfoKey, accessToken.getValue());
            }
        }
        HttpRequestUtils.successResponse(httpServletResponse, "退出登录成功", true);
    }
}
