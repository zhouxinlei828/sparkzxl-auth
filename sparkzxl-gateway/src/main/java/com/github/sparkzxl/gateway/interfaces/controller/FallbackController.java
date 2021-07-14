package com.github.sparkzxl.gateway.interfaces.controller;

import com.github.sparkzxl.core.base.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 响应超时熔断处理器
 *
 * @author charles.zhou
 * @date 2020-05-24 12:17:49
 */
@RestController
@Slf4j
public class FallbackController {

    @GetMapping("/fallback")
    public ApiResult fallback() {
        log.info("fallback 降级========>{}", "响应超时熔断处理器");
        return ApiResult.timeOut();
    }
}
