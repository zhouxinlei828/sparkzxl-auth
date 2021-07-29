package com.github.sparkzxl.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: 文件存储启动类
 *
 * @author charles.zhou
 * @date 2020-05-24 12:42:02
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.file"})
@EnableDiscoveryClient
public class FileCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileCenterApplication.class, args);
    }
}
