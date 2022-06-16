package com.github.sparkzxl.auth.interfaces.client;

import com.github.sparkzxl.auth.interfaces.client.result.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * description: 地区client
 *
 * @author zhouxinlei
 * @since 2021-10-14 14:35:47
 */
@FeignClient(contextId = "areaProvider", name = "area", url = "https://restapi.amap.com")
public interface AreaProvider {

    /**
     * 查询高德地区列表
     *
     * @param queryMap 查询参数
     * @return ResponseEntity
     */
    @GetMapping("/v3/config/district")
    ResponseEntity getAreaList(@SpringQueryMap Map<String, Object> queryMap);

}
