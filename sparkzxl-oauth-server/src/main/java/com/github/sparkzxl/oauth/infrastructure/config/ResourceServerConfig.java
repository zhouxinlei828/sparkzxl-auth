package com.github.sparkzxl.oauth.infrastructure.config;

import com.github.sparkzxl.core.util.ListUtils;
import com.github.sparkzxl.core.util.SwaggerStaticResource;
import com.github.sparkzxl.oauth.infrastructure.constant.SecurityConstants;
import com.github.sparkzxl.oauth.infrastructure.security.RestAuthenticationEntryPoint;
import com.github.sparkzxl.oauth.infrastructure.security.RestfulAccessDeniedHandler;
import com.github.sparkzxl.oauth.infrastructure.security.SecurityProperties;
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
 * @since 2021-02-01 11:30:00
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
        List<String> excludeStaticPatterns = Lists.newArrayList(
                SecurityConstants.DEFAULT_LOGIN_URL,
                SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM,
                SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
                SecurityConstants.DEFAULT_SIGN_IN_URL_MOBILE_PAGE,
                SecurityConstants.DEFAULT_REGISTER_URL,
                SecurityConstants.DEFAULT_SIGN_IN_TOKEN_REQUEST);
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
                        "/base/**",
                        "/org/**",
                        "/station/**",
                        "/application/**",
                        "/login/log/**");
    }
}
