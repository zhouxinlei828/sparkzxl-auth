package com.github.sparkzxl.gateway.infrastructure.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * description: 异常处理类
 *
 * @author zhouxinlei
 * @date 2021-08-18 13:01:16
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WebfluxExceptionHandler {
    Class<? extends Throwable> value();
}
