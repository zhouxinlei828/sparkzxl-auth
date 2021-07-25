package com.github.sparkzxl.workflow;

import lombok.extern.slf4j.Slf4j;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * description: 工作流引擎启动类
 *
 * @author charles.zhou
 * @date 2020-07-16 20:01:10
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.workflow"}, exclude = SecurityAutoConfiguration.class)
public class WorkflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowApplication.class, args);
    }

}
