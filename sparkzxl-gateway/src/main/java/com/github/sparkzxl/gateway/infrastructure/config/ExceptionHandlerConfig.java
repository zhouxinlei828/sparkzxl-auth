package com.github.sparkzxl.gateway.infrastructure.config;

import com.github.sparkzxl.gateway.infrastructure.handler.ExceptionHandlerAdvice;
import com.github.sparkzxl.gateway.infrastructure.handler.GateWayExceptionHandlerStrategy;
import com.github.sparkzxl.gateway.infrastructure.handler.JsonExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author charles.zhou
 * @date 2020-08-15 09:05:50
 */
@Configuration
@EnableConfigurationProperties({ServerProperties.class, ResourceProperties.class})
public class ExceptionHandlerConfig {

    private final ServerProperties serverProperties;

    private final ApplicationContext applicationContext;

    private final ResourceProperties resourceProperties;

    private final List<ViewResolver> viewResolvers;

    private final ServerCodecConfigurer serverCodecConfigurer;

    public ExceptionHandlerConfig(ServerProperties serverProperties,
                                  ResourceProperties resourceProperties,
                                  ObjectProvider<ViewResolver> viewResolversProvider,
                                  ServerCodecConfigurer serverCodecConfigurer,
                                  ApplicationContext applicationContext) {
        this.serverProperties = serverProperties;
        this.applicationContext = applicationContext;
        this.resourceProperties = resourceProperties;
        this.viewResolvers = viewResolversProvider.orderedStream()
                .collect(Collectors.toList());
        this.serverCodecConfigurer = serverCodecConfigurer;
    }


    @Bean
    public GateWayExceptionHandlerStrategy exceptionHandlerChooser(List<ExceptionHandlerAdvice> exceptionHandlerAdviceList) {
        GateWayExceptionHandlerStrategy gateWayExceptionHandlerStrategy = new GateWayExceptionHandlerStrategy();
        gateWayExceptionHandlerStrategy.setExceptionHandlerAdviceMap(exceptionHandlerAdviceList);
        return gateWayExceptionHandlerStrategy;
    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorWebExceptionHandler.class, search = SearchStrategy.CURRENT)
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ErrorWebExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes, GateWayExceptionHandlerStrategy exceptionHandlerChooser) {
        JsonExceptionHandler exceptionHandler = new JsonExceptionHandler(
                errorAttributes,
                resourceProperties,
                this.serverProperties.getError(),
                applicationContext,
                exceptionHandlerChooser);
        exceptionHandler.setViewResolvers(this.viewResolvers);
        exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
        exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
        return exceptionHandler;
    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorAttributes.class, search = SearchStrategy.CURRENT)
    public DefaultErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes();
    }
}
