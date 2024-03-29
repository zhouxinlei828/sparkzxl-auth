package com.github.sparkzxl.oauth.domain.service;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.net.url.UrlPath;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.auth.api.dto.UserDetail;
import com.github.sparkzxl.cache.service.CacheService;
import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.core.context.RequestLocalContextHolder;
import com.github.sparkzxl.core.util.KeyGeneratorUtil;
import com.github.sparkzxl.core.util.ListUtils;
import com.github.sparkzxl.core.util.RequestContextHolderUtils;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.oauth.application.service.IOauthService;
import com.github.sparkzxl.oauth.infrastructure.constant.OauthConstant;
import com.github.sparkzxl.oauth.infrastructure.oauth2.AccessTokenInfo;
import com.github.sparkzxl.oauth.infrastructure.oauth2.AuthorizationRequest;
import com.github.sparkzxl.oauth.infrastructure.oauth2.OpenProperties;
import com.github.sparkzxl.oauth.interfaces.client.UserInfoProvider;
import com.github.sparkzxl.user.manager.UserStateManager;
import com.google.common.collect.Maps;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.endpoint.CustomTokenGrantService;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * description：授权登录 服务实现类
 *
 * @author charles.zhou
 * @since 2020-06-24 14:50:40
 */
@Service
@Slf4j
public class OauthServiceImpl implements IOauthService {

    private TokenEndpoint tokenEndpoint;
    private CacheService cacheService;
    private UserInfoProvider userInfoProvider;
    private UserStateManager userStateManager;
    private ClientDetailsService clientDetailsService;
    private OpenProperties openProperties;
    private CustomTokenGrantService customTokenGrantService;

    @Autowired
    public void setTokenEndpoint(TokenEndpoint tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }

    @Autowired
    public void setGeneralCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Autowired
    public void setUserInfoClient(UserInfoProvider userInfoProvider) {
        this.userInfoProvider = userInfoProvider;
    }

    @Autowired
    public void setUserStateManager(UserStateManager userStateManager) {
        this.userStateManager = userStateManager;
    }

    @Autowired
    public void setClientDetailsService(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    @Autowired
    public void setOpenProperties(OpenProperties openProperties) {
        this.openProperties = openProperties;
    }

    @Autowired
    public void setCustomTokenGrantService(CustomTokenGrantService customTokenGrantService) {
        this.customTokenGrantService = customTokenGrantService;
    }

    @SneakyThrows
    @Override
    public OAuth2AccessToken getAccessToken(Principal principal, Map<String, String> parameters) {
        ResponseEntity<OAuth2AccessToken> oAuth2AccessTokenResponseEntity = tokenEndpoint.getAccessToken(principal, parameters);
        return loginEventAndBack(parameters, oAuth2AccessTokenResponseEntity.getBody());
    }

    private OAuth2AccessToken loginEventAndBack(Map<String, String> parameters, OAuth2AccessToken oAuth2AccessToken) {
        String grantType = parameters.get("grant_type");
        if ("client_credentials".equals(grantType)) {
            return oAuth2AccessToken;
        }
        buildGlobalUserInfo(oAuth2AccessToken);
        return oAuth2AccessToken;
    }

    @SneakyThrows
    @Override
    public OAuth2AccessToken postAccessToken(Principal principal, Map<String, String> parameters) {
        ResponseEntity<OAuth2AccessToken> oAuth2AccessTokenResponseEntity = tokenEndpoint.postAccessToken(principal, parameters);
        return loginEventAndBack(parameters, oAuth2AccessTokenResponseEntity.getBody());
    }

    @Override
    public AccessTokenInfo getAccessToken(AuthorizationRequest authorizationRequest) {
        Map<String, String> parameters = builderAccessTokenParameters(authorizationRequest);
        return createAccessToken(parameters);
    }

    @Override
    public AccessTokenInfo postAccessToken(AuthorizationRequest authorizationRequest) {
        return getAccessToken(authorizationRequest);
    }

    private AccessTokenInfo createAccessToken(Map<String, String> parameters) {
        OAuth2AccessToken accessToken = customTokenGrantService.getAccessToken(parameters);
        AccessTokenInfo accessTokenInfo = new AccessTokenInfo();
        accessTokenInfo.setAccessToken(accessToken.getValue());
        accessTokenInfo.setTokenType(accessToken.getTokenType());
        accessTokenInfo.setRefreshToken(accessToken.getRefreshToken().getValue());
        accessTokenInfo.setExpiration(accessToken.getExpiration());
        loginEventAndBack(parameters, accessToken);
        return accessTokenInfo;
    }

    /**
     * 设置accessToken缓存
     *
     * @param oAuth2AccessToken 认证token
     */
    private void buildGlobalUserInfo(OAuth2AccessToken oAuth2AccessToken) {
        Map<String, Object> additionalInformation = oAuth2AccessToken.getAdditionalInformation();
        String username = (String) additionalInformation.get("username");
        String tenant = (String) additionalInformation.get(BaseContextConstants.TENANT_ID);
        RequestLocalContextHolder.setTenant(tenant);
        AuthUserInfo<UserDetail> authUserInfo = userInfoProvider.getAuthUserInfo(username);
        userStateManager.addUser(oAuth2AccessToken.getValue(), authUserInfo, Duration.ofSeconds(oAuth2AccessToken.getExpiresIn()));
    }

    /**
     * 构建认证请求参数
     *
     * @param authorizationRequest 认证请求参数
     * @return Map<String, String>
     */
    private Map<String, String> builderAccessTokenParameters(AuthorizationRequest authorizationRequest) {
        Map<String, String> parameters = Maps.newHashMap();
        String grantType = authorizationRequest.getGrantType();
        parameters.put("grant_type", grantType);
        Optional.ofNullable(authorizationRequest.getRefreshToken()).ifPresent(value -> parameters.put("refresh_token", value));
        Optional.ofNullable(authorizationRequest.getUsername()).ifPresent(value -> parameters.put("username", value));
        Optional.ofNullable(authorizationRequest.getPassword()).ifPresent(value -> parameters.put("password", value));
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(authorizationRequest.getClientId());
        parameters.put("client_id", clientDetails.getClientId());
        parameters.put("client_secret", clientDetails.getClientSecret());
        Set<String> detailsScope = clientDetails.getScope();
        String scope = String.join(",", detailsScope);
        parameters.put("scope", scope);
        return parameters;
    }

    @Override
    public String getAuthorizeUrl(String clientId, String frontUrl) {
        String state = RandomUtil.randomString(6);
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(StringUtils.isNotEmpty(clientId) ? clientId
                : openProperties.getAppId());
        HttpServletRequest request = RequestContextHolderUtils.getRequest();
        List<String> redirectUriList = ListUtils.setToList(clientDetails.getRegisteredRedirectUri());
        String authorizeUrl = UrlBuilder.of(openProperties.getSsoServerUri(), StandardCharsets.UTF_8)
                .addPath("/oauth/authorize")
                .addQuery("client_id", clientDetails.getClientId())
                .addQuery("redirect_uri", redirectUriList.get(0))
                .addQuery("response_type", "code")
                .addQuery("state", state)
                .addQuery(BaseContextConstants.TENANT_ID, RequestLocalContextHolder.getTenant())
                .build();
        String referer = request.getHeader("Referer");
        if (StringUtils.isNotEmpty(referer)) {
            UrlBuilder builder = UrlBuilder.ofHttp(referer, CharsetUtil.CHARSET_UTF_8);
            builder.setPath(UrlPath.of("jump", StandardCharsets.UTF_8));
            String frontStateKey = KeyGeneratorUtil.generateKey(OauthConstant.FRONT_STATE, state);
            cacheService.set(frontStateKey, builder.build(), Duration.ofMinutes(5));
        }
        return EscapeUtil.safeUnescape(authorizeUrl);
    }

    @Override
    public AccessTokenInfo authorizationCodeCallBack(String authorizationCode, String loginState) {
        String frontStateKey = KeyGeneratorUtil.generateKey(OauthConstant.FRONT_STATE, loginState);
        String frontUrl = cacheService.get(frontStateKey);
        if (StringUtils.isEmpty(frontUrl)) {
            return null;
        }
        cacheService.remove(frontStateKey);
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(openProperties.getAppId());
        Map<String, String> parameters = Maps.newHashMap();
        parameters.put("grant_type", "authorization_code");
        Set<String> detailsScope = clientDetails.getScope();
        String scope = String.join(",", detailsScope);
        parameters.put("scope", scope);
        parameters.put("code", authorizationCode);
        parameters.put("client_id", clientDetails.getClientId());
        parameters.put("client_secret", clientDetails.getClientSecret());
        List<String> redirectUriList = ListUtils.setToList(clientDetails.getRegisteredRedirectUri());
        parameters.put("redirect_uri", redirectUriList.get(0));
        return createAccessToken(parameters);
    }

    @Override
    public AuthUserBasicVO userinfo(AuthUserInfo<UserDetail> authUserInfo) {
        RequestLocalContextHolder.setTenant(authUserInfo.getTenantId());
        return userInfoProvider.getUserByUserId(Long.valueOf(authUserInfo.getId()));
    }
}
