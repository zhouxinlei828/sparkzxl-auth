package com.github.sparkzxl.gateway.infrastructure.filter;

import cn.hutool.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-10-19 12:24:48
 */
@Slf4j
@Component
public class HttpRequestGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String requestUrl = request.getPath().toString();
        String requestMethod = request.getMethodValue();
        String contentType = request.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE);
        if (HttpMethod.POST.toString().equals(requestMethod) || HttpMethod.PUT.toString().equals(requestMethod)) {
            if (StringUtils.isNotEmpty(contentType) && !contentType.startsWith(ContentType.MULTIPART.getValue())){
                return DataBufferUtils.join(exchange.getRequest().getBody()).flatMap(dataBuffer -> {
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    DataBufferUtils.release(dataBuffer);
                    Flux<DataBuffer> cachedFlux = Flux.defer(() -> {
                        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                        return Mono.just(buffer);
                    });
                    // 下面的将请求体再次封装写回到request里，传到下一级，否则，由于请求体已被消费，后续的服务将取不到值
                    ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
                        @Override
                        public Flux<DataBuffer> getBody() {
                            return cachedFlux;
                        }
                    };
                    // 封装request，传给下一级
                    return chain.filter(exchange.mutate().request(mutatedRequest).build());
                });
            }
        } else if (HttpMethod.GET.toString().equals(requestMethod)
                || HttpMethod.DELETE.toString().equals(requestMethod)) {
            MultiValueMap<String, String> getRequestParams = request.getQueryParams();
            log.debug("\n 请求url:`{}` \n 请求类型：{} \n 请求参数：{}", requestUrl, requestMethod, getRequestParams);
            return chain.filter(exchange);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        int ordered = Integer.MIN_VALUE + 1;
        log.info("加载顺序：{}", ordered);
        return ordered;
    }
}
