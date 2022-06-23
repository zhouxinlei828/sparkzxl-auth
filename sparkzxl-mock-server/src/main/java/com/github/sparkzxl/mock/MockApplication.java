package com.github.sparkzxl.mock;

import com.github.sparkzxl.feign.resilience4j.autoconfigure.DefaultFeignClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: Mock启动类
 *
 * @author zhouxinlei
 * @since 2022-04-04 14:35:09
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.mock"})
@EnableFeignClients(basePackages = "com.github.sparkzxl.mock", defaultConfiguration = DefaultFeignClientConfiguration.class)
public class MockApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockApplication.class, args);
    }

}
