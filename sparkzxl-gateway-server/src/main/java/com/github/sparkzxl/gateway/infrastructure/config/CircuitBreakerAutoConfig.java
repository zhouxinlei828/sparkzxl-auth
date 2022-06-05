package com.github.sparkzxl.gateway.infrastructure.config;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: CircuitBreaker auto  Config
 *
 * @author zhouxinlei
 * @since 2022-04-03 11:47:47
 */
@Configuration
public class CircuitBreakerAutoConfig {


    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> customizerReactiveCircuitBreakerFactory() {
        return reactiveCircuitBreakerFactory -> reactiveCircuitBreakerFactory.configure(
                builder -> builder
                        .timeLimiterConfig(reactiveCircuitBreakerFactory.getTimeLimiterRegistry().getConfiguration("backendB")
                                .orElse(reactiveCircuitBreakerFactory.getTimeLimiterRegistry().getDefaultConfig()))
                        .circuitBreakerConfig(reactiveCircuitBreakerFactory.getCircuitBreakerRegistry().getConfiguration("backendB")
                                .orElse(reactiveCircuitBreakerFactory.getCircuitBreakerRegistry().getDefaultConfig())),
                "backendB");
    }
}
