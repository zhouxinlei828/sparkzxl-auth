package com.github.sparkzxl.gateway;

import com.github.sparkzxl.gateway.annotation.EnableGatewayPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 网关启动类
 *
 * @author charles.zhou
 * @date 2020-05-24 12:18:18
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.gateway"})
@EnableGatewayPlugin
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
