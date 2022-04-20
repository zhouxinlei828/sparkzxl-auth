package com.github.sparkzxl.system.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: 系统管理服务启动类
 *
 * @author zhouxinlei
 * @since 2022-04-20 15:03:37
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.system.admin"})
@EnableFeignClients(basePackages = "com.github.sparkzxl.system.admin")
@EnableDiscoveryClient
public class SystemAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemAdminApplication.class, args);
    }

}
