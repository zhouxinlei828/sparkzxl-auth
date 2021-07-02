package com.github.sparkzxl.auth.infrastructure.oauth2.event;

import com.github.sparkzxl.auth.infrastructure.oauth2.handler.AbstractAuthenticationSuccessEventHandler;
import com.github.sparkzxl.core.jackson.JsonUtil;
import com.github.sparkzxl.entity.security.AuthUserDetail;
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
        if (authentication.getPrincipal() instanceof AuthUserDetail) {
            log.info("用户：{} 登录成功", JsonUtil.toJsonPretty(authentication.getPrincipal()));
        }
    }
}
