package com.github.sparkzxl.gateway.infrastructure.filter;

import com.github.sparkzxl.constant.AppContextConstants;
import com.github.sparkzxl.core.base.result.ApiResponseStatus;
import com.github.sparkzxl.core.support.BaseException;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.github.sparkzxl.entity.core.JwtUserInfo;
import com.github.sparkzxl.gateway.filter.AbstractJwtAuthorizationFilter;
import com.github.sparkzxl.jwt.service.JwtTokenService;
import com.github.sparkzxl.oauth.properties.ResourceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * description: 权限过滤器
 *
 * @author charles.zhou
 * @date 2020-05-24 12:16:11
 */
@Component
@Slf4j
@RefreshScope
public class AuthTokenFilter extends AbstractJwtAuthorizationFilter {

    @Autowired
    private ResourceProperties resourceProperties;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public String getHeaderKey() {
        return AppContextConstants.JWT_TOKEN_HEADER;
    }

    @Override
    public List<String> ignorePatterns() {
        return Arrays.asList(resourceProperties.getIgnore());
    }

    @Override
    public JwtUserInfo getJwtUserInfo(String token) throws BaseException {
        try {
            return jwtTokenService.getAuthJwtInfo(token);
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionAssert.failure(ApiResponseStatus.JSON_PARSE_ERROR);
            return null;
        }
    }

    @Override
    protected Mono<Void> handleTokenEmpty(ServerWebExchange exchange, GatewayFilterChain chain, String token) {
        return chain.filter(exchange);
    }
}
