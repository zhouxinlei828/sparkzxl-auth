package com.github.sparkzxl.gateway.infrastructure.support;

import com.github.sparkzxl.core.base.result.ResponseResult;
import com.github.sparkzxl.gateway.support.GatewayException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class GatewayExceptionHandler {

    @ExceptionHandler({GatewayException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseResult handlerException(GatewayException e) {
        return ResponseResult.result(500, e.getMessage());
    }
}
