package com.github.sparkzxl.gateway.infrastructure.filter;

import com.github.sparkzxl.gateway.infrastructure.rule.RouteLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalancerUriTools;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.ReactiveLoadBalancerClientFilter;
import org.springframework.cloud.gateway.support.DelegatingServiceInstance;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * description: 网关路由负载均衡过滤器
 *
 * @author zhouxinlei
 * @date 2021-10-22 14:48:56
 */
@Component
@Slf4j
public class GatewayLoadBalancerClientFilter extends ReactiveLoadBalancerClientFilter {

    private static final int LOAD_BALANCER_CLIENT_FILTER_ORDER = 10150;
    private static final String LB = "lb";

    private final RouteLoadBalancer routeLoadBalancer;
    private final LoadBalancerProperties properties;


    public GatewayLoadBalancerClientFilter(RouteLoadBalancer routeLoadBalancer, LoadBalancerProperties properties) {
        super(null, properties);
        this.routeLoadBalancer = routeLoadBalancer;
        this.properties = properties;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI url = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
        String schemePrefix = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_SCHEME_PREFIX_ATTR);
//        StrUtil.equalsAny(LB, url.getScheme(), schemePrefix)
        if (url == null || (!LB.equals(url.getScheme()) && !LB.equals(schemePrefix))) {
            return chain.filter(exchange);
        }

        // preserve the original url
        ServerWebExchangeUtils.addOriginalRequestUrl(exchange, url);

        if (log.isTraceEnabled()) {
            log.trace(ReactiveLoadBalancerClientFilter.class.getSimpleName() + " url before: " + url);
        }
        // 这里呢会进行调用真正的负载均衡
        return choose(exchange).doOnNext(response -> {
            if (!response.hasServer()) {
                throw NotFoundException.create(properties.isUse404(),
                        "Unable to find instance for " + url.getHost());
            }

            URI uri = exchange.getRequest().getURI();

            // if the `lb:<scheme>` mechanism was used, use `<scheme>` as the default,
            // if the loadbalancer doesn't provide one.
            String overrideScheme = null;
            if (schemePrefix != null) {
                overrideScheme = url.getScheme();
            }

            DelegatingServiceInstance serviceInstance = new DelegatingServiceInstance(
                    response.getServer(), overrideScheme);

            URI requestUrl = LoadBalancerUriTools.reconstructURI(serviceInstance, uri);

            if (log.isTraceEnabled()) {
                log.trace("LoadBalancerClientFilter url chosen: " + requestUrl);
            }
            exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR, requestUrl);
        }).then(chain.filter(exchange));
    }

    private Mono<Response<ServiceInstance>> choose(ServerWebExchange exchange) {
        URI uri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
        ServiceInstance serviceInstance = routeLoadBalancer.choose(uri.getHost(), exchange.getRequest());
        return Mono.just(new DefaultResponse(serviceInstance));
    }

    @Override
    public int getOrder() {
        return LOAD_BALANCER_CLIENT_FILTER_ORDER;
    }

}
