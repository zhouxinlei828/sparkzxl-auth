package com.github.sparkzxl.oauth.infrastructure.security.handle;

import com.github.sparkzxl.core.support.code.ResultErrorCode;
import com.github.sparkzxl.core.util.HttpRequestUtils;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2021-06-14 08:45:41
 */
@Slf4j
@Component
public class CustomizeAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.error("登陆失败：{}", exception.getMessage());
        HttpRequestUtils.failResponse(response,
                ResultErrorCode.LOGIN_EXPIRE);
    }
}
