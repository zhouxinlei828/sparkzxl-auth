package com.github.sparkzxl.gateway.infrastructure.handler;

import cn.hutool.core.bean.OptionalBean;
import cn.hutool.core.text.StrFormatter;
import com.github.sparkzxl.core.base.result.ApiResponseStatus;
import com.github.sparkzxl.core.base.result.ApiResult;
import com.github.sparkzxl.core.support.BizException;
import com.github.sparkzxl.gateway.infrastructure.annotation.WebfluxExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * description: 网关全局异常处理
 *
 * @author zhouxinlei
 * @date 2021-08-18 13:18:47
 */
@Slf4j
public class GateWayExceptionHandlerStrategy {

    private Map<Class<? extends Throwable>, ExceptionHandlerAdvice> exceptionHandlerAdviceMap;

    public void setExceptionHandlerAdviceMap(List<ExceptionHandlerAdvice> exceptionHandlerAdviceList) {
        // 注入各种类型的订单处理类
        exceptionHandlerAdviceMap = exceptionHandlerAdviceList.stream().collect(
                Collectors.toMap(businessHandler -> Objects.requireNonNull(AnnotationUtils.findAnnotation(businessHandler.getClass(), WebfluxExceptionHandler.class)).value(),
                        v -> v, (v1, v2) -> v1));
    }

    public ApiResult<?> handleException(Throwable throwable) {
        ExceptionHandlerAdvice exceptionHandlerAdvice = exceptionHandlerAdviceMap.get(throwable.getClass());
        if (ObjectUtils.isEmpty(exceptionHandlerAdvice)) {
            return ApiResult.apiResult(500, throwable.getMessage());
        }
        return exceptionHandlerAdvice.handleException(throwable);
    }

    @WebfluxExceptionHandler(BizException.class)
    public static class BizExceptionHandlerAdvice implements ExceptionHandlerAdvice {

        @Override
        public ApiResult<?> handleException(Throwable throwable) {
            return ApiResult.apiResult(500, throwable.getMessage());
        }
    }

    @WebfluxExceptionHandler(NotFoundException.class)
    public static class NotFoundExceptionHandlerAdvice implements ExceptionHandlerAdvice {

        @Override
        public ApiResult<?> handleException(Throwable throwable) {
            NotFoundException exception = (NotFoundException) throwable;
            log.error("NotFoundException：[{}]", exception.getReason());
            String matchString = "Unable to find instance for ";
            String message = exception.getReason();
            if (message.contains(matchString)) {
                int indexOf = message.lastIndexOf("for ") + 4;
                String serviceName = message.substring(indexOf);
                String applicationName = OptionalBean.ofNullable(serviceName).orElseGet(() -> "unKnownServer");
                if (applicationName == null) {
                    message = exception.getMessage();
                } else {
                    message = StrFormatter.format(ApiResponseStatus.OPEN_SERVICE_UNAVAILABLE.getMessage(), applicationName);
                }
            }
            return ApiResult.apiResult(ApiResponseStatus.OPEN_SERVICE_UNAVAILABLE.getCode(), message);
        }
    }

    @WebfluxExceptionHandler(ResponseStatusException.class)
    public static class ResponseStatusExceptionHandlerAdvice implements ExceptionHandlerAdvice {

        @Override
        public ApiResult<?> handleException(Throwable throwable) {
            return ApiResult.apiResult(500, "请求响应失败");
        }
    }

}
