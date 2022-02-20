package com.github.sparkzxl.oauth.infrastructure.oauth2;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.core.base.result.ExceptionErrorCode;
import com.github.sparkzxl.entity.response.Response;
import com.github.sparkzxl.oauth.infrastructure.constant.enums.UserExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.exceptions.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: oauth 异常处理
 *
 * @author charles.zhou
 * @date 2020-08-03 12:42:19
 */
@ControllerAdvice
@RestController
@Slf4j
public class Oauth2ExceptionHandler {

    @ExceptionHandler(value = OAuth2Exception.class)
    public Response<?> handleOauth2(OAuth2Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.LOGIN_ERROR.getCode(), UserExceptionCode.LOGIN_ERROR.getMessage());
    }

    @ExceptionHandler(value = BadClientCredentialsException.class)
    public Response<?> handleBadClientCredentialsException(BadClientCredentialsException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.BAD_CLIENT_CREDENTIALS_EXCEPTION.getCode(), UserExceptionCode.BAD_CLIENT_CREDENTIALS_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = ClientAuthenticationException.class)
    public Response<?> handleClientAuthenticationException(ClientAuthenticationException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.CLIENT_AUTHENTICATION_EXCEPTION.getCode(), UserExceptionCode.CLIENT_AUTHENTICATION_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = InsufficientScopeException.class)
    public Response<?> handleInsufficientScopeException(InsufficientScopeException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.INSUFFICIENT_SCOPE_EXCEPTION.getCode(), UserExceptionCode.INSUFFICIENT_SCOPE_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = InvalidClientException.class)
    public Response<?> handleInvalidClientException(InvalidClientException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.INVALID_CLIENT_EXCEPTION.getCode(), UserExceptionCode.INVALID_CLIENT_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = InvalidGrantException.class)
    public Response<?> handleInvalidGrantException(InvalidGrantException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.INVALID_GRANT_EXCEPTION.getMessage(), UserExceptionCode.INVALID_GRANT_EXCEPTION.getMessage());
    }


    @ExceptionHandler(value = InvalidRequestException.class)
    public Response<?> handleInvalidRequestException(InvalidRequestException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(String.valueOf(e.getHttpErrorCode()), e.getMessage());
    }

    @ExceptionHandler(value = InvalidScopeException.class)
    public Response<?> handleInvalidScopeException(InvalidScopeException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.INVALID_REQUEST_EXCEPTION.getCode(), UserExceptionCode.INVALID_REQUEST_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = InvalidTokenException.class)
    public Response<?> handleInvalidTokenException(InvalidTokenException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.INVALID_TOKEN_EXCEPTION.getCode(), UserExceptionCode.INVALID_TOKEN_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = RedirectMismatchException.class)
    public Response<?> handleRedirectMismatchException(RedirectMismatchException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.REDIRECT_MISMATCH_EXCEPTION.getCode(), UserExceptionCode.REDIRECT_MISMATCH_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = SerializationException.class)
    public Response<?> handleSerializationException(SerializationException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(ExceptionErrorCode.FAILURE.getCode(), "Oauth2序列化出错");
    }

    @ExceptionHandler(value = UnapprovedClientAuthenticationException.class)
    public Response<?> handleUnapprovedClientAuthenticationException(UnapprovedClientAuthenticationException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.UNAPPROVED_CLIENT_AUTHENTICATION_EXCEPTION.getCode(), UserExceptionCode.UNAPPROVED_CLIENT_AUTHENTICATION_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = UnauthorizedClientException.class)
    public Response<?> handleUnapprovedClientAuthenticationException(UnauthorizedClientException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.UNAUTHORIZED_CLIENT_EXCEPTION.getCode(), UserExceptionCode.UNAUTHORIZED_CLIENT_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = UnsupportedResponseTypeException.class)
    public Response<?> handleUnsupportedResponseTypeException(UnsupportedResponseTypeException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.UNSUPPORTED_RESPONSE_TYPE_EXCEPTION.getCode(), UserExceptionCode.UNSUPPORTED_RESPONSE_TYPE_EXCEPTION.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnsupportedGrantTypeException.class)
    public Response<?> handleUnapprovedClientAuthenticationException(UnsupportedGrantTypeException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Response.failDetail(UserExceptionCode.UNSUPPORTED_GRANT_TYPE_EXCEPTION.getCode(), UserExceptionCode.UNSUPPORTED_GRANT_TYPE_EXCEPTION.getMessage());
    }

}
