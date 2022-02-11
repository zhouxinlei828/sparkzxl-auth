package com.github.sparkzxl.oauth.application.service;

import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.auth.api.dto.UserDetail;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.oauth.infrastructure.oauth2.AccessTokenInfo;
import com.github.sparkzxl.oauth.infrastructure.oauth2.AuthorizationRequest;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.security.Principal;
import java.util.Map;

/**
 * description: Oauth认证 服务类
 *
 * @author charles.zhou
 * @date 2020-06-25 09:49:22
 */
public interface IOauthService {

    /**
     * get请求授权登录
     *
     * @param principal  认证主体
     * @param parameters 认证请求
     * @return OAuth2AccessToken
     * @throws HttpRequestMethodNotSupportedException 请求方法异常
     */
    OAuth2AccessToken getAccessToken(Principal principal, Map<String, String> parameters) throws HttpRequestMethodNotSupportedException;

    /**
     * POST请求授权登录
     *
     * @param principal  认证主体
     * @param parameters 认证请求
     * @return OAuth2AccessToken
     * @throws HttpRequestMethodNotSupportedException 请求方法异常
     */
    OAuth2AccessToken postAccessToken(Principal principal, Map<String, String> parameters) throws HttpRequestMethodNotSupportedException;

    /**
     * POST请求授权登录
     *
     * @param authorizationRequest 授权请求参数
     * @return AccessTokenInfo
     */
    AccessTokenInfo getAccessToken(AuthorizationRequest authorizationRequest);

    /**
     * POST请求授权登录
     *
     * @param authorizationRequest 授权请求参数
     * @return AccessTokenInfo
     */
    AccessTokenInfo postAccessToken(AuthorizationRequest authorizationRequest);

    /**
     * 获取授权认证连接
     *
     * @param clientId 客户端id
     * @param frontUrl 前端地址
     * @return String
     */
    String getAuthorizeUrl(String clientId, String frontUrl);

    /**
     * 授权回调处理
     *
     * @param authorizationCode 授权码
     * @param loginState        登录态
     * @return AccessTokenInfo
     */
    AccessTokenInfo authorizationCodeCallBack(String authorizationCode, String loginState);

    /**
     * 查询用户信息
     *
     * @param authUserInfo 全局用户
     * @return AuthUserBasicVO
     */
    AuthUserBasicVO userinfo(AuthUserInfo<UserDetail> authUserInfo);
}
