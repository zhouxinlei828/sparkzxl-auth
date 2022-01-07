package com.github.sparkzxl.oauth.infrastructure.constant.enums;

import com.github.sparkzxl.core.base.code.ICode;
import com.github.sparkzxl.oauth.infrastructure.constant.OauthRespStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserExceptionCode implements ICode {

    USER_ERROR(OauthRespStatus.USER_ERROR_STATUS, "用户端错误"),
    LOGIN_ERROR(OauthRespStatus.LOGIN_ERROR_STATUS, "用户登录异常"),
    BAD_CLIENT_CREDENTIALS_EXCEPTION(OauthRespStatus.BAD_CLIENT_CREDENTIALS_EXCEPTION_STATUS, "错误的客户端凭证"),
    CLIENT_AUTHENTICATION_EXCEPTION(OauthRespStatus.CLIENT_AUTHENTICATION_EXCEPTION_STATUS, "客户端身份验证异常"),
    INSUFFICIENT_SCOPE_EXCEPTION(OauthRespStatus.INSUFFICIENT_SCOPE_EXCEPTION_STATUS, "未允许的scope范围请求"),
    INVALID_CLIENT_EXCEPTION(OauthRespStatus.INVALID_CLIENT_EXCEPTION_STATUS, "无效客户端id"),
    INVALID_GRANT_EXCEPTION(OauthRespStatus.INVALID_GRANT_EXCEPTION_STATUS, "无效授权请求"),
    INVALID_SCOPE_EXCEPTION(OauthRespStatus.INVALID_SCOPE_EXCEPTION_STATUS, "无效scope请求"),
    INVALID_TOKEN_EXCEPTION(OauthRespStatus.INVALID_TOKEN_STATUS, "无效token"),
    REDIRECT_MISMATCH_EXCEPTION(OauthRespStatus.REDIRECT_MISMATCH_EXCEPTION_STATUS, "重定向路径不匹配"),
    UNAPPROVED_CLIENT_AUTHENTICATION_EXCEPTION(OauthRespStatus.UNAPPROVED_CLIENT_AUTHENTICATION_EXCEPTION_STATUS, "未经批准的客户端认证请求"),
    UNAUTHORIZED_CLIENT_EXCEPTION(OauthRespStatus.UNAUTHORIZED_CLIENT_EXCEPTION_STATUS, "未经授权的客户端认证请求"),
    UNSUPPORTED_RESPONSE_TYPE_EXCEPTION(OauthRespStatus.UNSUPPORTED_RESPONSE_TYPE_EXCEPTION_STATUS, "响应类型不支持"),
    UNSUPPORTED_GRANT_TYPE_EXCEPTION(OauthRespStatus.UNSUPPORTED_GRANT_TYPE_EXCEPTION_STATUS, "授权类型不支持"),
    INVALID_REQUEST_EXCEPTION(OauthRespStatus.INVALID_REQUEST_EXCEPTION_STATUS, "无效的请求"),
    ;

    final String code;

    final String message;
}
