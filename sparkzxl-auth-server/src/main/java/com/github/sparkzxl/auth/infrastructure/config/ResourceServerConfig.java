package com.github.sparkzxl.auth.infrastructure.config;

import com.github.sparkzxl.auth.infrastructure.security.RestAuthenticationEntryPoint;
import com.github.sparkzxl.auth.infrastructure.security.RestfulAccessDeniedHandler;
import com.github.sparkzxl.auth.infrastructure.security.SecurityProperties;
import com.github.sparkzxl.core.resource.SwaggerStaticResource;
import com.github.sparkzxl.core.utils.ListUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import java.util.List;

/**
 * description: 资源服务器
 *
 * @author charles.zhou
 * @date 2021-02-01 11:30:00
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    private SecurityProperties securityProperties;

    @Autowired
    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        RestAuthenticationEntryPoint restAuthenticationEntryPoint = new RestAuthenticationEntryPoint();
        RestfulAccessDeniedHandler restfulAccessDeniedHandler = new RestfulAccessDeniedHandler();
        List<String> excludeStaticPatterns = Lists.newArrayList();
        excludeStaticPatterns.addAll(SwaggerStaticResource.EXCLUDE_STATIC_PATTERNS);
        List<String> ignorePatterns = securityProperties.getIgnorePatterns();
        if (CollectionUtils.isNotEmpty(ignorePatterns)) {
            excludeStaticPatterns.addAll(ignorePatterns);
        }
        List<String> ignoreStaticPatterns = securityProperties.getIgnoreStaticPatterns();
        if (CollectionUtils.isNotEmpty(ignoreStaticPatterns)) {
            excludeStaticPatterns.addAll(ignoreStaticPatterns);
        }
        http.authorizeRequests()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .antMatchers(ListUtils.listToArray(excludeStaticPatterns)).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .requestMatchers()
                .antMatchers(
                        "/menu/**",
                        "/resource/**",
                        "/role/**",
                        "/user/**",
                        "/common/**",
                        "/org/**",
                        "/station/**",
                        "/application/**",
                        "/realm/**");
    }
}
