package com.github.sparkzxl.workflow.infrastructure.config;

import com.github.sparkzxl.workflow.infrastructure.diagram.ICustomProcessDiagramGenerator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * description: Activiti配置
 *
 * @author charles.zhou
 * @date 2020-07-17 14:01:53
 */
@Configuration
public class ActivitiConfig extends AbstractProcessEngineAutoConfiguration {

    @Autowired
    private ICustomProcessDiagramGenerator customProcessDiagramGenerator;

    @Autowired
    private SnowFlakeGenerator snowFlakeGenerator;

    @Primary
    @Bean
    public ThreadPoolTaskExecutor workFlowTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        executor.setCorePoolSize(corePoolSize);
        int maxPoolSize = Runtime.getRuntime().availableProcessors() * 2;
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(300);
        executor.setQueueCapacity(300);
        executor.setThreadNamePrefix("workFlowTaskExecutor-");
        executor.initialize();
        return executor;
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            DataSource dataSource, DataSourceTransactionManager dataSourceTransactionManager) throws IOException {

        SpringAsyncExecutor asyncExecutor = new SpringAsyncExecutor();
        asyncExecutor.setTaskExecutor(workFlowTaskExecutor());
        //注入数据源和事务管理器
        SpringProcessEngineConfiguration processEngineConfiguration = this
                .baseSpringProcessEngineConfiguration(dataSource, dataSourceTransactionManager, asyncExecutor);
        //自定义流程图样式
        processEngineConfiguration.setProcessDiagramGenerator(customProcessDiagramGenerator);
        return processEngineConfiguration;
    }

    @Bean
    public ProcessEngineConfigurationImpl processEngineConfigurationImpl(ProcessEngineConfigurationImpl processEngineConfigurationImpl) {
        //设置ProcessEngineConfigurationImpl里的uuidGenerator
        processEngineConfigurationImpl.setIdGenerator(snowFlakeGenerator);
        //设置DbSqlSessionFactory的uuidGenerator，否则流程id，任务id，实例id依然是用DbIdGenerator生成
        processEngineConfigurationImpl.getDbSqlSessionFactory().setIdGenerator(snowFlakeGenerator);
        return processEngineConfigurationImpl;
    }
}
