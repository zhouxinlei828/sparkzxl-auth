package com.github.sparkzxl.auth.application.event;

import com.github.sparkzxl.auth.application.service.ILoginLogService;
import com.github.sparkzxl.auth.domain.model.aggregates.LoginStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * description: 权限资源变更事件监听，用于调整具体的业务
 *
 * @author charles.zhou
 * @since 2021-03-08 14:19:51
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class LoginListener {

    private ILoginLogService loginLogService;

    @Autowired
    public void setLoginLogService(ILoginLogService loginLogService) {
        this.loginLogService = loginLogService;
    }


    @Async
    @EventListener({LoginEvent.class})
    public void loginListenerEvent(LoginEvent event) {
        LoginStatus<Long> source = (LoginStatus<Long>) event.getSource();
        loginLogService.save(source);
    }
}
