package com.github.sparkzxl.oauth.infrastructure.oauth2;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.entity.response.Response;
import com.github.sparkzxl.core.util.RequestContextHolderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.exceptions.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    public void handleResponseResult() {
        HttpServletRequest servletRequest = RequestContextHolderUtils.getRequest();
        servletRequest.removeAttribute(BaseContextConstants.RESPONSE_RESULT_ANN);
    }

    @ResponseBody
    @ExceptionHandler(value = OAuth2Exception.class)
    public Response<?> handleOauth2(OAuth2Exception e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = BadClientCredentialsException.class)
    public Response<?> handleBadClientCredentialsException(BadClientCredentialsException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ClientAuthenticationException.class)
    public Response<?> handleClientAuthenticationException(ClientAuthenticationException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InsufficientScopeException.class)
    public Response<?> handleInsufficientScopeException(InsufficientScopeException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidClientException.class)
    public Response<?> handleInvalidClientException(InvalidClientException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidGrantException.class)
    public Response<?> handleInvalidGrantException(InvalidGrantException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(value = InvalidRequestException.class)
    public Response<?> handleInvalidRequestException(InvalidRequestException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidScopeException.class)
    public Response<?> handleInvalidScopeException(InvalidScopeException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidTokenException.class)
    public Response<?> handleInvalidTokenException(InvalidTokenException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), "token校验失败");
    }

    @ResponseBody
    @ExceptionHandler(value = RedirectMismatchException.class)
    public Response<?> handleRedirectMismatchException(RedirectMismatchException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = SerializationException.class)
    public Response<?> handleSerializationException(SerializationException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(500, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnapprovedClientAuthenticationException.class)
    public Response<?> handleUnapprovedClientAuthenticationException(UnapprovedClientAuthenticationException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(500, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnauthorizedClientException.class)
    public Response<?> handleUnapprovedClientAuthenticationException(UnauthorizedClientException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnsupportedResponseTypeException.class)
    public Response<?> handleUnsupportedResponseTypeException(UnsupportedResponseTypeException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnsupportedGrantTypeException.class)
    public Response<?> handleUnapprovedClientAuthenticationException(UnsupportedGrantTypeException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return Response.fail(e.getHttpErrorCode(), e.getMessage());
    }

}
