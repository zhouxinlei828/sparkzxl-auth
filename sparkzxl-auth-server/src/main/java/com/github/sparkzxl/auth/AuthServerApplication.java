package com.github.sparkzxl.auth;

import com.github.sparkzxl.boot.SparkBootApplication;
import com.github.sparkzxl.core.spring.SpringContextUtils;
import com.github.sparkzxl.log.netty.LogWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 认证授权启动类
 *
 * @author charles.zhou
 * @date   2021-02-01 11:18:40
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.auth"})
@Slf4j
public class AuthServerApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
        startNettyServer(8761, null, SpringContextUtils.getBean(LogWebSocketHandler.class));
    }
}
