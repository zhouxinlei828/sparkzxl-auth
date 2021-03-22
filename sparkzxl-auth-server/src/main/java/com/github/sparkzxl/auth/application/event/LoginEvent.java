package com.github.sparkzxl.auth.application.event;

import com.github.sparkzxl.auth.domain.model.aggregates.LoginStatus;
import org.springframework.context.ApplicationEvent;

/**
 * description: 登录事件
 *
 * @author zhouxinlei
 */
public class LoginEvent extends ApplicationEvent {

    public LoginEvent(LoginStatus source) {
        super(source);
    }
}
