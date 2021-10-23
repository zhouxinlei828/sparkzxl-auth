package com.github.sparkzxl.oauth.infrastructure.oauth2;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.core.base.result.ResponseResult;
import com.github.sparkzxl.core.utils.RequestContextHolderUtils;
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
    public ResponseResult<?> handleOauth2(OAuth2Exception e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = BadClientCredentialsException.class)
    public ResponseResult<?> handleBadClientCredentialsException(BadClientCredentialsException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ClientAuthenticationException.class)
    public ResponseResult<?> handleClientAuthenticationException(ClientAuthenticationException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InsufficientScopeException.class)
    public ResponseResult<?> handleInsufficientScopeException(InsufficientScopeException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidClientException.class)
    public ResponseResult<?> handleInvalidClientException(InvalidClientException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidGrantException.class)
    public ResponseResult<?> handleInvalidGrantException(InvalidGrantException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseResult<?> handleInvalidRequestException(InvalidRequestException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidScopeException.class)
    public ResponseResult<?> handleInvalidScopeException(InvalidScopeException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseResult<?> handleInvalidTokenException(InvalidTokenException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), "token校验失败");
    }

    @ResponseBody
    @ExceptionHandler(value = RedirectMismatchException.class)
    public ResponseResult<?> handleRedirectMismatchException(RedirectMismatchException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = SerializationException.class)
    public ResponseResult<?> handleSerializationException(SerializationException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(500, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnapprovedClientAuthenticationException.class)
    public ResponseResult<?> handleUnapprovedClientAuthenticationException(UnapprovedClientAuthenticationException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(500, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnauthorizedClientException.class)
    public ResponseResult<?> handleUnapprovedClientAuthenticationException(UnauthorizedClientException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnsupportedResponseTypeException.class)
    public ResponseResult<?> handleUnsupportedResponseTypeException(UnsupportedResponseTypeException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UnsupportedGrantTypeException.class)
    public ResponseResult<?> handleUnapprovedClientAuthenticationException(UnsupportedGrantTypeException e) {
        handleResponseResult();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.result(e.getHttpErrorCode(), e.getMessage());
    }

}
