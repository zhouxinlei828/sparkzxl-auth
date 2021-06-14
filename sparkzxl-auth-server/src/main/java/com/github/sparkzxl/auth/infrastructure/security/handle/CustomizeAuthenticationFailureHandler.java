package com.github.sparkzxl.auth.infrastructure.security.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sparkzxl.core.base.result.ApiResponseStatus;
import com.github.sparkzxl.core.base.result.ApiResult;
import com.github.sparkzxl.core.utils.ResponseResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: 自定义登录失败处理
 *
 * @author zhoux
 * @date 2021-06-14 08:45:41
 */
@Slf4j
@Component
public class CustomizeAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        log.error("登陆失败：{}", exception.getMessage());
        int code = ApiResponseStatus.PARAM_VALID_ERROR.getCode();
        String message = exception.getMessage();
        if (exception instanceof BadCredentialsException) {
            message = "用户名或密码错误";
        }
        ResponseResultUtils.writeResponseOutMsg(response,
                code, message);
    }
}
