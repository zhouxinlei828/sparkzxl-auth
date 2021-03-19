package com.github.sparkzxl.gateway.infrastructure.filter;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * description: 为了解决 历史遗留问题！
 * spring mvc有ContextPath的配置选项，webflux因为没有DispatchServlet，已经不支持ContextPath了，
 * 一般来说都是在nginx统一配置路径转发就好了。本地调试时可能就需要稍微注意下了，要么本地也装个nginx和线上环境保持一致，
 * 要么就做差异化配置，还有种方法，通过WebFilter的方式做一层ContextPath的转发，不过有一定风险，不推荐使用。
 *
 * @author charles.zhou
 * @date 2020-05-24 12:15:34
 */
@Component

public class ContextPathFilter implements WebFilter {

    @Resource
    private ServerProperties serverProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain webFilterChain) {
        String contextPath = serverProperties.getServlet().getContextPath();
        String requestPath = exchange.getRequest().getPath().pathWithinApplication().value();
        if (contextPath != null && requestPath.startsWith(contextPath)) {
            requestPath = requestPath.substring(contextPath.length());
        }
        return webFilterChain.filter(exchange.mutate().request(exchange.getRequest().mutate().path(requestPath).build()).build());
    }
}
