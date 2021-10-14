package com.github.sparkzxl.auth.infrastructure.client;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.LogLevel;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.LogStrategy;
import com.github.sparkzxl.auth.infrastructure.client.result.ResponseEntity;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-10-14 14:35:47
 */
@RetrofitClient(baseUrl = "${area.url}", logLevel = LogLevel.INFO, logStrategy = LogStrategy.BODY)
public interface AreaClient {

    /**
     * 查询高德地区列表
     *
     * @param queryMap 查询参数
     * @return ResponseEntity
     */
    @GET("/v3/config/district")
    ResponseEntity getAreaList(@QueryMap Map<String, Object> queryMap);

}
