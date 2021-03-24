package com.github.sparkzxl.job.admin.controller.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * description: web mvc config
 *
 * @author charles.zhou
 * @date   2021-03-12 15:38:39
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private CookieInterceptor cookieInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cookieInterceptor).addPathPatterns("/**");
    }

}
