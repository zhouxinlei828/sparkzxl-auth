package com.github.sparkzxl.workflow.application.event;

import cn.hutool.core.text.StrSplitter;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.github.sparkzxl.core.util.StringHandlerUtil;
import com.github.sparkzxl.workflow.infrastructure.enums.ListenerEventEnum;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-07-28 15:10
 */
@Component
@Slf4j
public class DynamicDataSourceChangeListener implements ApplicationListener<EnvironmentChangeEvent> {

    private final String datasourcePrefix = DynamicDataSourceProperties.PREFIX.concat(".datasource.");

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;
    @Autowired(required = false)
    private DynamicDataSourceProperties dynamicDataSourceProperties;
    @Autowired(required = false)
    private DataSource dataSource;
    @Autowired(required = false)
    private DefaultDataSourceCreator dataSourceCreator;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        Map<String, DataSourceProperty> dataSourceMap = dynamicDataSourceProperties.getDatasource();
        Map<String, ListenerEventEnum> dataSourceEventMap = Maps.newHashMap();
        for (String key : event.getKeys()) {
            if (StringUtils.startsWith(key, datasourcePrefix)) {
                String substringAfter = StringUtils.removeStartIgnoreCase(key, datasourcePrefix);
                List<String> split = StrSplitter.split(substringAfter, '.', 0, true, true);
                String dataSourceKey = split.get(0);
                System.out.println(dataSourceKey);
                String property = configurableEnvironment.getProperty(key);
                if (StringUtils.isBlank(property)) {
                    dataSourceEventMap.put(dataSourceKey, ListenerEventEnum.DELETE);
                } else {
                    dataSourceEventMap.put(dataSourceKey, ListenerEventEnum.UPDATE);
                }
                DataSourceProperty dataSourceProperty = dataSourceMap.getOrDefault(dataSourceKey, new DataSourceProperty());
                String dataSourcePropertyName = split.get(1);
                createDataSourceProperty(dataSourceProperty, dataSourcePropertyName, property);
                dataSourceMap.put(dataSourceKey, dataSourceProperty);
            }
            log.info("\n[key({}) 最新 value 为 {}]", key, configurableEnvironment.getProperty(key));
        }
        log.info("\nMap {}", JSONUtil.toJsonPrettyStr(dataSourceMap));
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        for (String key : dataSourceEventMap.keySet()) {
            ListenerEventEnum listenerEventEnum = dataSourceEventMap.get(key);
            if (listenerEventEnum.equals(ListenerEventEnum.DELETE)) {
                ds.removeDataSource(key);
            } else if (listenerEventEnum.equals(ListenerEventEnum.UPDATE)) {
                DataSource dataSource = dataSourceCreator.createDataSource(dataSourceMap.get(key));
                ds.addDataSource(key, dataSource);
            }
        }
        Map<String, DataSource> dataSources = ds.getDataSources();
        dynamicDataSourceProperties.setDatasource(dataSourceMap);
    }

    public void createDataSourceProperty(DataSourceProperty dataSourceProperty, String dataSourcePropertyName, String property) {
        String fieldName = StringHandlerUtil.underscoreToCamelCase(dataSourcePropertyName);
        ReflectUtil.setFieldValue(dataSourceProperty, fieldName, property);
    }

}
