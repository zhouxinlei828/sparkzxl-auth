package com.github.sparkzxl.auth.application.service;

import com.github.sparkzxl.auth.infrastructure.oauth2.AccessTokenInfo;
import com.github.sparkzxl.auth.infrastructure.oauth2.AuthorizationRequest;
import com.github.sparkzxl.core.entity.CaptchaInfo;
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
     * 生成验证码
     *
     * @param type 验证码类型
     * @return CaptchaInfo
     */
    CaptchaInfo createCaptcha(String type);

    /**
     * 校验验证码
     *
     * @param key   前端上送 key
     * @param value 前端上送待校验值
     * @return 是否成功
     */
    boolean checkCaptcha(String key, String value);

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

}
