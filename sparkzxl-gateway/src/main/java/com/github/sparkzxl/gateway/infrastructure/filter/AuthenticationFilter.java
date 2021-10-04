package com.github.sparkzxl.gateway.infrastructure.filter;

import com.github.sparkzxl.constant.AppContextConstants;
import com.github.sparkzxl.core.base.result.ApiResponseStatus;
import com.github.sparkzxl.core.support.BaseException;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.github.sparkzxl.core.utils.BuildKeyUtil;
import com.github.sparkzxl.core.utils.ListUtils;
import com.github.sparkzxl.entity.core.JwtUserInfo;
import com.github.sparkzxl.gateway.filter.AbstractJwtAuthorizationFilter;
import com.github.sparkzxl.gateway.infrastructure.constant.BizConstant;
import com.github.sparkzxl.gateway.properties.ResourceProperties;
import com.github.sparkzxl.gateway.utils.WebFluxUtils;
import com.github.sparkzxl.jwt.service.JwtTokenService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
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
@RequiredArgsConstructor
@RefreshScope
public class AuthenticationFilter extends AbstractJwtAuthorizationFilter {

    private final ResourceProperties resourceProperties;
    private final JwtTokenService jwtTokenService;
    private final RedisTemplate<String, Object> redisTemplate;
    private final GatewayProperties gatewayProperties;
    private final ServerProperties serverProperties;

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

    @Override
    protected JwtUserInfo checkTokenAuthority(String token, ServerWebExchange exchange) throws BaseException {
        JwtUserInfo jwtUserInfo = super.checkTokenAuthority(token, exchange);
        //从Redis中获取当前路径可访问角色列表
        ServerHttpRequest request = exchange.getRequest();
        String requestUrl = request.getPath().toString();
        final String[] path = {requestUrl};
        gatewayProperties.getRoutes().forEach(route -> {
            String prefix = "/".concat(route.getId());
            path[0] = path[0].replace(prefix, "");
        });
        String routePath = path[0];
        String tenant = WebFluxUtils.getHeader(AppContextConstants.TENANT_ID, request);
        List<String> authorities = Lists.newArrayList();
        String cacheKey = BuildKeyUtil.generateKey(AppContextConstants.RESOURCE_ROLES_MAP, tenant);
        if (BizConstant.USER_PATH.equals(routePath) || BizConstant.USER_ROUTER_PATH.equals(routePath)) {
            authorities.add(BizConstant.USER_CODE);
        }
        String obj = (String) redisTemplate.opsForHash().get(cacheKey, routePath);
        if (ObjectUtils.isNotEmpty(obj)) {
            List<String> stringList = ListUtils.stringToList(obj);
            authorities.addAll(stringList);
        }
        if (CollectionUtils.containsAny(jwtUserInfo.getAuthorities(), authorities)) {
            return jwtUserInfo;
        }
        throw new BaseException(ApiResponseStatus.AUTHORIZED_DENIED);
    }
}
