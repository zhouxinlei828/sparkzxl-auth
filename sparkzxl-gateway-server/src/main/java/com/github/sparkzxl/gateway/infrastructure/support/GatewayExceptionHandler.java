package com.github.sparkzxl.gateway.infrastructure.support;

import com.github.sparkzxl.core.base.result.Response;
import com.github.sparkzxl.core.support.JwtExpireException;
import com.github.sparkzxl.core.support.JwtInvalidException;
import com.github.sparkzxl.gateway.plugin.support.GatewayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * description: 全局异常处理
 *
 * @author zhouxinlei
 * @since 2022-06-16 09:56:02
 */
@Component
@Slf4j
public class GatewayExceptionHandler {

    @ExceptionHandler({GatewayException.class})
    public Response<?> handlerException(GatewayException e) {
        log.error("网关异常：", e);
        return Response.fail(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler({JwtExpireException.class})
    public Response<?> handlerJwtExpireException(JwtExpireException e) {
        log.error("网关JWT异常：", e);
        return Response.fail(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler({JwtInvalidException.class})
    public Response<?> handlerJwtExpireException(JwtInvalidException e) {
        log.error("网关JWT转换异常：", e);
        return Response.fail(e.getErrorCode(), e.getErrorMsg());
    }
}
