package com.github.sparkzxl.gateway.infrastructure.handler;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * description: 异常处理（json）
 *
 * @author charles.zhou
 * @date   2020-12-10 11:17:23
*/
@Slf4j
public class JsonExceptionHandler implements ErrorWebExceptionHandler {


    /**
     * MessageReader
     */
    private final List<HttpMessageReader<?>> messageReaders;

    /**
     * MessageWriter
     */
    private final List<HttpMessageWriter<?>> messageWriters;

    /**
     * ViewResolvers
     */
    private final List<ViewResolver> viewResolvers;

    /**
     * 存储处理异常后的信息
     */
    private final ThreadLocal<Map<String, Object>> exceptionHandlerResult = new ThreadLocal<>();

    public JsonExceptionHandler(List<HttpMessageReader<?>> messageReaders,
                                List<HttpMessageWriter<?>> messageWriters,
                                List<ViewResolver> viewResolvers) {
        this.messageReaders = messageReaders;
        this.messageWriters = messageWriters;
        this.viewResolvers = viewResolvers;
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpRequest request = exchange.getRequest();
        // 按照异常类型进行处理
        HttpStatus httpStatus;
        String body;
        if (ex instanceof NotFoundException) {
            httpStatus = HttpStatus.NOT_FOUND;
            body = "Service Not Found";
        } else if (ex instanceof ResponseStatusException) {
            ResponseStatusException responseStatusException = (ResponseStatusException) ex;
            httpStatus = responseStatusException.getStatus();
            body = responseStatusException.getMessage();
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            body = buildMessage(request,ex);
        }

        Map<String, Object> result = response(httpStatus.value(),body);
        //错误记录
        log.error("[全局异常处理]异常请求路径:{},记录异常信息:{}", request.getPath(), ex.getMessage());
        //参考AbstractErrorWebExceptionHandler
        if (exchange.getResponse().isCommitted()) {
            return Mono.error(ex);
        }
        exceptionHandlerResult.set(result);
        ServerRequest newRequest = ServerRequest.create(exchange, this.messageReaders);
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse).route(newRequest)
                .switchIfEmpty(Mono.error(ex))
                .flatMap((handler) -> handler.handle(newRequest))
                .flatMap((response) -> write(exchange, response));

    }

    /**
     * 参考DefaultErrorWebExceptionHandler
     */
    protected Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        Map<String, Object> errorAttributes = exceptionHandlerResult.get();
        Integer status = (Integer) errorAttributes.get("status");
        if (ObjectUtils.isEmpty(status)) {
            status = (Integer) errorAttributes.get("code");
        }
        Mono<ServerResponse> serverResponseMono = ServerResponse.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorAttributes));
        exceptionHandlerResult.remove();
        return serverResponseMono;
    }

    /**
     * 参考AbstractErrorWebExceptionHandler
     */
    private Mono<? extends Void> write(ServerWebExchange exchange,
                                       ServerResponse response) {
        exchange.getResponse().getHeaders()
                .setContentType(response.headers().getContentType());
        return response.writeTo(exchange, new ResponseContext());
    }

    /**
     * 参考AbstractErrorWebExceptionHandler
     */
    private class ResponseContext implements ServerResponse.Context {

        @Override
        public List<HttpMessageWriter<?>> messageWriters() {
            return JsonExceptionHandler.this.messageWriters;
        }

        @Override
        public List<ViewResolver> viewResolvers() {
            return JsonExceptionHandler.this.viewResolvers;
        }

    }

    /**
     * 构建异常信息
     *
     * @param request
     * @param ex
     * @return
     */
    private String buildMessage(ServerHttpRequest request, Throwable ex) {
        StringBuilder message = new StringBuilder("Failed to handle request [");
        message.append(request.getMethod().name());
        message.append(" ");
        message.append(request.getPath());
        message.append("]");
        if (ex != null) {
            message.append(": ");
            message.append(ex.getMessage());
        }
        return message.toString();
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
}
