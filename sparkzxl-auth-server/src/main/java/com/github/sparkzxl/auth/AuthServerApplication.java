package com.github.sparkzxl.auth;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 认证授权启动类
 *
 * @author charles.zhou
 * @date   2021-02-01 11:18:40
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.auth"})
public class AuthServerApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
