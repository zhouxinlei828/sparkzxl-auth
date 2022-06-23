/*
package com.github.sparkzxl.auth.infrastructure.executor;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.github.sparkzxl.auth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthApplicationMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

*/
/**
 * description:
 *
 * @author charles.zhou
 * @since 2021-03-17 10:48:18
 *//*

@Slf4j
@Component
public class ApplicationHealthCheckJob {

    private AuthApplicationMapper authApplicationMapper;

    @Autowired
    public void setAuthApplicationMapper(AuthApplicationMapper authApplicationMapper) {
        this.authApplicationMapper = authApplicationMapper;
    }

    @XxlJob("applicationHealthCheck")
    public ReturnT<String> applicationHealthCheck(String param) {
        List<AuthApplication> authApplications = authApplicationMapper.applicationList();
        authApplications.forEach(authApplication -> {
            if (StringUtils.isNotEmpty(authApplication.getHealthCheck())) {
                try {
                    HttpResponse httpResponse = HttpRequest.get(authApplication.getHealthCheck()).execute();
                    boolean responseOk = httpResponse.isOk();
                    authApplication.setHealthStatus(responseOk);
                    authApplicationMapper.updateById(authApplication);
                } catch (Exception e) {
                    log.error("定时任务发生异常：{}", e.getMessage());
                }
            }
        });
        return ReturnT.SUCCESS;
    }
}
*/
