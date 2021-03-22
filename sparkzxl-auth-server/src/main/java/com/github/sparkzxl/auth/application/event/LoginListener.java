package com.github.sparkzxl.auth.application.event;

import com.github.sparkzxl.auth.domain.model.aggregates.LoginStatus;
import com.github.sparkzxl.auth.domain.repository.ILoginLogRepository;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLog;
import com.github.sparkzxl.core.entity.UserAgentEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * description: 权限资源变更事件监听，用于调整具体的业务
 *
 * @author charles.zhou
 * @date 2021-03-08 14:19:51
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class LoginListener {

    private ILoginLogRepository loginLogRepository;

    @Autowired
    public void setLoginLogRepository(ILoginLogRepository loginLogRepository) {
        this.loginLogRepository = loginLogRepository;
    }


    @Async
    @EventListener({LoginEvent.class})
    public void loginListenerEvent(LoginEvent event) {
        LoginStatus<Long> source = (LoginStatus<Long>) event.getSource();
        UserAgentEntity userAgentEntity = source.getUserAgentEntity();
        LoginLog loginLog = LoginLog.builder()
                .requestIp(userAgentEntity.getRequestIp())
                .userId(source.getId())
                .userName(source.getName())
                .account(source.getAccount())
                .description(source.getDescription())
                .loginDate(LocalDateTime.now())
                .ua(userAgentEntity.getUa())
                .browser(userAgentEntity.getBrowser())
                .browserVersion(userAgentEntity.getBrowserVersion())
                .operatingSystem(userAgentEntity.getOperatingSystem())
                .location(userAgentEntity.getLocation())
                .realmCode(source.getRealmCode())
                .build();
        loginLogRepository.saveLoginLog(loginLog);
    }
}
