package com.github.sparkzxl.workflow.interfaces.controller;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * description: Mock数据管理
 *
 * @author zhouxinlei
 * @date 2021-07-28 14:31
 */
@ResponseResult
@RestController
@RequestMapping("/mock")
@WebLog
@Api(tags = "Mock数据管理")
@RefreshScope
public class MockController {

    @Autowired
    private DynamicDataSourceProperties dynamicDataSourceProperties;

    @GetMapping("/testDynamicDataSource")
    public Map<String, DataSourceProperty> testDynamicDataSource() {
        return dynamicDataSourceProperties.getDatasource();
    }
}
