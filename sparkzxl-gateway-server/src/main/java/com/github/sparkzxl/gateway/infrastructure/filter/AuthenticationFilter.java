//package com.github.sparkzxl.gateway.infrastructure.filter;
//
//import com.github.sparkzxl.constant.BaseContextConstants;
//import com.github.sparkzxl.core.base.result.ExceptionCode;
//import com.github.sparkzxl.core.util.KeyGeneratorUtil;
//import com.github.sparkzxl.core.util.ListUtils;
//import com.github.sparkzxl.entity.core.JwtUserInfo;
//import com.github.sparkzxl.gateway.constant.ExchangeAttributeConstant;
//import com.github.sparkzxl.gateway.context.GatewayContext;
//import com.github.sparkzxl.gateway.filter.authorization.AbstractAuthorizationFilter;
//import com.github.sparkzxl.gateway.infrastructure.constant.BizConstant;
//import com.github.sparkzxl.gateway.properties.GatewayResourceProperties;
//import com.github.sparkzxl.gateway.support.GatewayException;
//import com.github.sparkzxl.gateway.util.ReactorHttpHelper;
//import com.github.sparkzxl.jwt.service.JwtTokenService;
//import com.google.common.collect.Lists;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.server.ServerWebExchange;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * description: 权限过滤器
// *
// * @author charles.zhou
// * @date 2020-05-24 12:16:11
// */
//@Component
//@Slf4j
//@RequiredArgsConstructor
//@RefreshScope
//public class AuthenticationFilter extends AbstractAuthorizationFilter {
//
//    private final GatewayResourceProperties resourceProperties;
//    private final JwtTokenService jwtTokenService;
//    private final RedisTemplate<String, Object> redisTemplate;
//
//    @Override
//    public String getHeaderKey() {
//        return BaseContextConstants.JWT_TOKEN_HEADER;
//    }
//
//    @Override
//    public JwtUserInfo getJwtUserInfo(String token) throws GatewayException {
//        try {
//            return jwtTokenService.getAuthJwtInfo(token);
//        } catch (Exception e) {
//            throw new GatewayException(ExceptionCode.JSON_PARSE_ERROR);
//        }
//    }
//
//
//    @Override
//    protected void checkTokenAuthority(ServerWebExchange exchange, String token) throws GatewayException {
//        super.checkTokenAuthority(exchange, token);
//        JwtUserInfo jwtUserInfo = exchange.getAttribute(ExchangeAttributeConstant.USER_INFO);
//        GatewayContext gatewayContext = exchange.getAttribute(GatewayContext.GATEWAY_CONTEXT_CONSTANT);
//        ServerHttpRequest request = exchange.getRequest();
//        String path = gatewayContext.getPath();
//        String tenant = ReactorHttpHelper.getHeader(BaseContextConstants.TENANT_ID, request);
//        List<String> authorities = Lists.newArrayList();
//        String cacheKey = KeyGeneratorUtil.generateKey(BaseContextConstants.RESOURCE_ROLES_MAP, tenant);
//        if (BizConstant.USER_PATH.equals(path) || BizConstant.USER_ROUTER_PATH.equals(path)) {
//            authorities.add(BizConstant.USER_CODE);
//        }
//        String obj = (String) redisTemplate.opsForHash().get(cacheKey, path);
//        if (ObjectUtils.isNotEmpty(obj)) {
//            authorities.addAll(ListUtils.stringToList(obj));
//        }
//        if (!CollectionUtils.containsAny(jwtUserInfo.getAuthorities(), authorities)) {
//            throw new GatewayException(ExceptionCode.AUTHORIZED_DENIED);
//        }
//    }
//}
