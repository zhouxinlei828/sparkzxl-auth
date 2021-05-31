package com.github.sparkzxl.auth.infrastructure.oauth2.event;

import cn.hutool.json.JSONUtil;
import com.github.sparkzxl.auth.infrastructure.oauth2.handler.AbstractAuthenticationSuccessEventHandler;
import com.github.sparkzxl.auth.infrastructure.security.AuthUserDetail;
import com.github.sparkzxl.core.jackson.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-05-31 10:49
 */
@Slf4j
@Component
public class DefaultAuthenticationSuccessEventHandler extends AbstractAuthenticationSuccessEventHandler {

    @Override
    public void handle(Authentication authentication) {
        AuthUserDetail userDetails = (AuthUserDetail) authentication.getPrincipal();
        log.info("用户：{} 登录成功", JsonUtil.toJsonPretty(userDetails));
    }
}
