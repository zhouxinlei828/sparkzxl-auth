package com.github.sparkzxl.tenant;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 租户服务启动类
 *
 * @author zhouxinlei
 * @date 2021-07-03 10:06:56
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.tenant"})
public class TenantServerApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenantServerApplication.class, args);
    }

}
