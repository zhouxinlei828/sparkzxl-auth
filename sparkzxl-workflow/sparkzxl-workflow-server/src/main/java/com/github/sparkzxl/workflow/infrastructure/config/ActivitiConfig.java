
package com.github.sparkzxl.workflow.infrastructure.config;

import com.github.sparkzxl.workflow.infrastructure.diagram.ICustomProcessDiagramGenerator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * description: Activiti配置
 *
 * @author charles.zhou
 * @date   2020-07-17 14:01:53
*/
@Configuration
public class ActivitiConfig extends AbstractProcessEngineAutoConfiguration {

    @Autowired
    private DataSource dataSource;

    @Resource
    private PlatformTransactionManager transactionManager;

    @Autowired
    private ICustomProcessDiagramGenerator customProcessDiagramGenerator;

    @Autowired
    private SnowFlakeGenerator snowFlakeGenerator;

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            SpringAsyncExecutor springAsyncExecutor) throws IOException {

        //注入数据源和事务管理器
        SpringProcessEngineConfiguration springProcessEngineConfiguration = this
                .baseSpringProcessEngineConfiguration(dataSource, transactionManager,
                        springAsyncExecutor);
        //close job executor
        springProcessEngineConfiguration.setAsyncExecutorActivate(false);
        //自定义流程图样式
        springProcessEngineConfiguration.setProcessDiagramGenerator(customProcessDiagramGenerator);
        return springProcessEngineConfiguration;
    }

    @Bean
    public ProcessEngineConfigurationImpl processEngineConfigurationImpl(ProcessEngineConfigurationImpl processEngineConfigurationImpl){
        //设置ProcessEngineConfigurationImpl里的uuidGenerator
        processEngineConfigurationImpl.setIdGenerator(snowFlakeGenerator);
        //设置DbSqlSessionFactory的uuidGenerator，否则流程id，任务id，实例id依然是用DbIdGenerator生成
        processEngineConfigurationImpl.getDbSqlSessionFactory().setIdGenerator(snowFlakeGenerator);
        return processEngineConfigurationImpl;
    }
}
