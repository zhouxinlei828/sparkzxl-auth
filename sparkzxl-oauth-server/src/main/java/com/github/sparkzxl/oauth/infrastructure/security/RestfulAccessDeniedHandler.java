package com.github.sparkzxl.oauth.infrastructure.security;

import com.github.sparkzxl.core.support.code.ResultErrorCode;
import com.github.sparkzxl.core.util.HttpRequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 当访问接口没有权限时，自定义的返回结果
 *
 * @author charles.zhou
 * @since 2020-05-24 13:35:14
 */
@Slf4j
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) {
        log.error("AccessDeniedException：{}", e.getMessage());
        HttpRequestUtils.failResponse(response, ResultErrorCode.AUTHORIZED_DENIED);
    }
}
