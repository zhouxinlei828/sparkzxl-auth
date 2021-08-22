package com.github.sparkzxl.ids;

import com.github.sparkzxl.ids.infrastructure.constant.OauthConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: oauth2 启动类
 *
 * @author zhoux
 * @date 2021-08-22 12:03:39
 */
@SpringBootApplication(scanBasePackages = {OauthConstant.BUSINESS_PACKAGE})
public class IdsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdsServerApplication.class, args);
    }

}
