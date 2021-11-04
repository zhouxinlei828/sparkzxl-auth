package com.github.sparkzxl.workflow.interfaces.controller;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.github.sparkzxl.AlarmFactoryExecute;
import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.core.context.RequestLocalContextHolder;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.github.sparkzxl.core.support.TenantException;
import com.github.sparkzxl.core.utils.RequestContextHolderUtils;
import com.github.sparkzxl.database.factory.CustomThreadFactory;
import com.github.sparkzxl.file.dto.FileDTO;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.workflow.infrastructure.client.FileClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description: Mock数据管理
 *
 * @author zhouxinlei
 * @date 2021-07-28 14:31
 */
@ResponseResult
@RestController
@RequestMapping("/mock")
@HttpRequestLog
@Api(tags = "Mock数据管理")
@RefreshScope
public class MockController {

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
            4,
            10,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(30),
            new CustomThreadFactory());
    @Autowired(required = false)
    private DynamicDataSourceProperties dynamicDataSourceProperties;
    @Autowired
    private FileClient fileClient;

    @GetMapping("/testDynamicDataSource")
    public Map<String, DataSourceProperty> testDynamicDataSource() {
        ExceptionAssert.failure("test全局异常");
        return dynamicDataSourceProperties.getDatasource();
    }

    @GetMapping("/getPdf")
    public FileDTO getPdf() {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFilePath("1111");
        return fileClient.getPdf(fileDTO);
    }

    @GetMapping("/test")
    public String testMultithreading() {
        String tenantId = RequestContextHolderUtils.getHeader("tenantId");
        RequestLocalContextHolder.setTenant(tenantId);
        CompletableFuture.runAsync(() -> {
            String header = RequestContextHolderUtils.getHeader("tenantId");
            System.out.println(header);
            System.out.println("全局租户id".concat(RequestLocalContextHolder.getTenant()));
        }, threadPoolExecutor);
        return tenantId;
    }

    @GetMapping("/testException")
    public String testException() {
        CompletableFuture.runAsync(() -> AlarmFactoryExecute.execute("<span style=\"color:red;\">测试单号：</span>JC345345345345"), threadPoolExecutor);
        throw new TenantException("无此租户");
    }
}
