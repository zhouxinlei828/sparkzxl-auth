package com.github.sparkzxl.gateway.infrastructure.support;

import com.github.sparkzxl.core.support.JwtExpireException;
import com.github.sparkzxl.core.support.JwtInvalidException;
import com.github.sparkzxl.entity.response.Response;
import com.github.sparkzxl.gateway.plugin.support.GatewayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * description: 全局异常处理
 *
 * @author zhouxinlei
 * @date 2021-12-15 21:36:32
 */
@Component
@Slf4j
public class GatewayExceptionHandler {

    @ExceptionHandler({GatewayException.class})
    public Response<?> handlerException(GatewayException e) {
        log.error("网关异常：", e);
        return Response.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler({JwtExpireException.class})
    public Response<?> handlerJwtExpireException(JwtExpireException e) {
        log.error("网关JWT异常：", e);
        return Response.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler({JwtInvalidException.class})
    public Response<?> handlerJwtExpireException(JwtInvalidException e) {
        log.error("网关JWT转换异常：", e);
        return Response.fail(e.getCode(), e.getMessage());
    }
}
