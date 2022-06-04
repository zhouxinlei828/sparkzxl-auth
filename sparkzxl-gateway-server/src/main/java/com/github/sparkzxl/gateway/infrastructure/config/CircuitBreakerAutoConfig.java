package com.github.sparkzxl.gateway.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

/**
 * description: CircuitBreaker auto  Config
 *
 * @author zhouxinlei
 * @since 2022-04-03 11:47:47
 */
public class CircuitBreakerAutoConfig {

    @Bean
    public ReactiveResilience4JCircuitBreakerFactory reactiveCircuitBreakerFactory(CircuitBreakerRegistry circuitBreakerRegistry, TimeLimiterRegistry timeLimiterRegistry) {
        ReactiveResilience4JCircuitBreakerFactory reactiveCircuitBreakerFactory = new ReactiveResilience4JCircuitBreakerFactory(circuitBreakerRegistry, timeLimiterRegistry);
        reactiveCircuitBreakerFactory.configure(
                builder -> builder
                        .timeLimiterConfig(timeLimiterRegistry.getConfiguration("backendB").orElse(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(300)).build()))
                        .circuitBreakerConfig(circuitBreakerRegistry.getConfiguration("backendB").orElse(circuitBreakerRegistry.getDefaultConfig())),
                "backendB");
        return reactiveCircuitBreakerFactory;
    }

}
