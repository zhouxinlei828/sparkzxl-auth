package com.github.sparkzxl.workflow;

import com.github.sparkzxl.boot.SparkBootApplication;
import com.github.sparkzxl.core.spring.SpringContextUtils;
import com.github.sparkzxl.log.netty.LogWebSocketHandler;
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
public class WorkflowApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowApplication.class, args);
        startNettyServer(null, null, SpringContextUtils.getBean(LogWebSocketHandler.class));
    }

}
