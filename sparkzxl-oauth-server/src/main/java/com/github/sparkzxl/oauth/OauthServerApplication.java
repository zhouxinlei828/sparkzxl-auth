package com.github.sparkzxl.oauth;

import com.github.sparkzxl.feign.resilience4j.autoconfigure.DefaultFeignClientConfiguration;
import com.github.sparkzxl.oauth.infrastructure.constant.OauthConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: oauth2 启动类
 *
 * @author zhoux
 * @since 2021-08-22 12:03:39
 */
@SpringBootApplication(scanBasePackages = {OauthConstant.BUSINESS_PACKAGE})
@EnableFeignClients(basePackages = OauthConstant.BUSINESS_FEIGN_PACKAGE,defaultConfiguration = DefaultFeignClientConfiguration.class)
public class OauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class, args);
    }

}
