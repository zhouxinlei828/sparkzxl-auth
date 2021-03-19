package com.github.sparkzxl.gateway.infrastructure.filter;

import com.github.sparkzxl.core.context.BaseContextConstants;
import com.github.sparkzxl.core.entity.JwtUserInfo;
import com.github.sparkzxl.core.support.BaseException;
import com.github.sparkzxl.core.support.ResponseResultStatus;
import com.github.sparkzxl.core.support.SparkZxlExceptionAssert;
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
    private JwtTokenService<Long> jwtTokenService;

    @Override
    public String getHeaderKey() {
        return BaseContextConstants.JWT_TOKEN_HEADER;
    }

    @Override
    public List<String> ignorePatterns() {
        return Arrays.asList(resourceProperties.getIgnorePatterns());
    }

    @Override
    public JwtUserInfo getJwtUserInfo(String token) throws BaseException {
        try {
            return jwtTokenService.getAuthJwtInfo(token);
        } catch (Exception e) {
            e.printStackTrace();
            SparkZxlExceptionAssert.businessFail(ResponseResultStatus.JSON_PARSE_ERROR);
            return null;
        }
    }
    @Override
    protected Mono<Void> handleTokenEmpty(ServerWebExchange exchange, GatewayFilterChain chain, String token) {
        return chain.filter(exchange);
    }
}
