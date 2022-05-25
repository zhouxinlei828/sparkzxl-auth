package com.github.sparkzxl.mock;

import com.github.sparkzxl.alarm.autoconfigure.TemplateConfig;
import com.github.sparkzxl.alarm.provider.AlarmTemplateProvider;
import com.github.sparkzxl.alarm.provider.FileAlarmTemplateProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author blackj
 * Description Bnea Config
 */
@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    @Bean
    @ConditionalOnProperty(prefix = TemplateConfig.PREFIX, name = "enabled", havingValue = "true")
    public AlarmTemplateProvider alarmTemplateProvider(TemplateConfig templateConfig) {
        return new FileAlarmTemplateProvider(templateConfig);
    }
}
