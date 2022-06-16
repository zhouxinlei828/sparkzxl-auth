package com.github.sparkzxl.oauth.infrastructure.constant;

/**
 * description:  权限常量类
 *
 * @author zhouxinlei
 * @since 2021-07-11 09:51:19
 */
public interface SecurityConstants {

    /**
     * 当请求需要身份验证时跳转URL
     */
    String DEFAULT_LOGIN_URL = "/authentication/require";

    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE = "/authentication/mobile";

    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_SIGN_IN_URL_MOBILE_PAGE = "/authentication/mobilePage";

    /**
     * 默认的用户注册请求处理url
     */
    String DEFAULT_REGISTER_URL = "/authentication/register";

    /**
     * 授权登录接口
     */
    String DEFAULT_SIGN_IN_TOKEN_REQUEST = "/authentication/token";

    /**
     * 默认的主页测
     */
    String DEFAULT_SIGNUP_URL = "/register";

    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";

    /**
     * 默认用户密码
     */
    String DEFAULT_PASSWORD = "123456";

    /**
     * mock
     */
    String MOCK_REQUEST = "/mock/**";
}
