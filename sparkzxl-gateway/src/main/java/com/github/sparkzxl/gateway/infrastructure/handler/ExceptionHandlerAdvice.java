package com.github.sparkzxl.gateway.infrastructure.handler;

import com.github.sparkzxl.core.base.result.ApiResult;

/**
 * description: 异常处理策略类
 *
 * @author zhouxinlei
 * @date 2021-08-18 13:15:40
 */
public interface ExceptionHandlerAdvice {

    /**
     * 异常处理
     *
     * @param throwable 异常
     * @return ApiResult
     */
    ApiResult<?> handleException(Throwable throwable);
}
