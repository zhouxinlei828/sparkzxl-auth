package com.github.sparkzxl.gateway.infrastructure.config;

import com.github.sparkzxl.gateway.infrastructure.filter.GatewayLoadBalancerClientFilter;
import com.github.sparkzxl.gateway.infrastructure.rule.RouteVersionLoadBalancer;
import com.github.sparkzxl.gateway.infrastructure.rule.RouteLoadBalancer;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.gateway.config.GatewayReactiveLoadBalancerClientAutoConfiguration;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.ReactiveLoadBalancerClientFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: 网关路由负载模式自动装配
 *
 * @author zhouxinlei
 * @date 2021-10-22 22:00:19
 */
@Configuration
@AutoConfigureBefore(GatewayReactiveLoadBalancerClientAutoConfiguration.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
public class RouteLoadBalancerClientConfig {

    @Bean
    public RouteLoadBalancer grayscaleLoadBalancer() {
        return new RouteVersionLoadBalancer();
    }

    @Bean
    public ReactiveLoadBalancerClientFilter gatewayLoadBalancerClientFilter(RouteLoadBalancer grayLoadBalancer,
                                                                            LoadBalancerProperties properties) {
        return new GatewayLoadBalancerClientFilter(grayLoadBalancer, properties);
    }

}
