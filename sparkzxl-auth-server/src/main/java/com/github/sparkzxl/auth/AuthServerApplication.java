package com.github.sparkzxl.auth;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: 认证授权启动类
 *
 * @author charles.zhou
 * @date 2021-02-01 11:18:40
 */
@SpringBootApplication(scanBasePackages = {BizConstant.BUSINESS_PACKAGE})
@EnableFeignClients(basePackages = BizConstant.BUSINESS_FEIGN_PACKAGE)
@EnableDiscoveryClient
@RetrofitScan(basePackages = "com.github.sparkzxl.auth.infrastructure.client")
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
