package com.github.sparkzxl.auth.infrastructure.config;

import com.github.sparkzxl.alarm.send.AlarmSender;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * description: 密码加密配置类
 *
 * @author zhouxinlei
 * @since 2021-08-26 10:56:03
 */
@RequiredArgsConstructor
@Configuration
public class PasswordEncoderConfig {

    private final AlarmSender alarmSender;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
