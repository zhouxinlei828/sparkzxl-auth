package com.github.sparkzxl.oauth.infrastructure.security;

import com.github.sparkzxl.core.base.result.ResponseInfoStatus;
import com.github.sparkzxl.core.context.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 当未登录或者token失效访问接口时，自定义的返回结果
 *
 * @author charles.zhou
 * @date 2020-05-24 13:35:00
 */
@Slf4j
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) {
        log.error("AuthenticationException：{}", e.getMessage());
        int code = ResponseInfoStatus.UN_AUTHORIZED.getCode();
        String message = ResponseInfoStatus.UN_AUTHORIZED.getMessage();
        if (e instanceof AccountExpiredException) {
            code = ResponseInfoStatus.TOKEN_EXPIRED_ERROR.getCode();
            message = ResponseInfoStatus.TOKEN_EXPIRED_ERROR.getMessage();
        }
        ResponseHelper.writeResponseOutMsg(response,
                code, message);
    }

}
