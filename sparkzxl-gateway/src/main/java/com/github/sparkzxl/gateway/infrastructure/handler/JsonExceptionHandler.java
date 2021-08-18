package com.github.sparkzxl.gateway.infrastructure.handler;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * description: 异常处理（json）
 *
 * @author charles.zhou
 * @date 2020-12-10 11:17:23
 */
@Slf4j
public class JsonExceptionHandler extends DefaultErrorWebExceptionHandler {


    public GateWayExceptionHandlerStrategy gateWayExceptionHandlerStrategy;

    public JsonExceptionHandler(ErrorAttributes errorAttributes,
                                ResourceProperties resourceProperties,
                                ErrorProperties errorProperties,
                                ApplicationContext applicationContext,
                                GateWayExceptionHandlerStrategy gateWayExceptionHandlerStrategy) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
        this.gateWayExceptionHandlerStrategy = gateWayExceptionHandlerStrategy;
    }

    /**
     * 构建返回的JSON数据格式
     *
     * @param status       状态码
     * @param errorMessage 异常信息
     * @return Map<String, Object>
     */
    public static Map<String, Object> response(int status, String errorMessage) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", status);
        map.put("msg", errorMessage);
        map.put("data", null);
        map.put("success", status == 200);
        log.error(map.toString());
        return map;
    }

    @Override
    @SuppressWarnings("all")
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    @Override
    protected Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        Map<String, Object> error = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
        int errorStatus = getHttpStatus(error);
        Throwable throwable = getError(request);
        return ServerResponse.status(errorStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(gateWayExceptionHandlerStrategy.handleException(throwable)));
    }
}
