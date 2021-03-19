package com.github.sparkzxl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 网关启动类
 *
 * @author charles.zhou
 * @date 2020-05-24 12:18:18
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.gateway"})
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
