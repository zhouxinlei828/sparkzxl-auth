package com.github.sparkzxl.gateway.infrastructure.authorization;

import com.github.sparkzxl.core.context.BaseContextConstants;
import com.github.sparkzxl.core.entity.JwtUserInfo;
import com.github.sparkzxl.core.utils.BuildKeyUtils;
import com.github.sparkzxl.core.utils.ListUtils;
import com.github.sparkzxl.gateway.infrastructure.constant.RoleConstant;
import com.github.sparkzxl.gateway.utils.WebFluxUtils;
import com.github.sparkzxl.jwt.service.JwtTokenService;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 鉴权管理器，用于判断是否有资源的访问权限
 *
 * @author charles.zhou
 * @date 2020-08-02 18:00:02
 */
@Component
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    public static final String RESOURCE_ROLES_MAP = "auth:resource_roles_map";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private GatewayProperties gatewayProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private JwtTokenService<Long> jwtTokenService;

    @SneakyThrows
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        //从Redis中获取当前路径可访问角色列表
        URI uri = request.getURI();
        final String[] path = {uri.getPath()};
        gatewayProperties.getRoutes().forEach(route -> {
            String prefix = serverProperties.getServlet().getContextPath().concat("/").concat(route.getId());
            path[0] = path[0].replace(prefix, "");
        });
        String routePath = path[0];
        String token = WebFluxUtils.getHeader(BaseContextConstants.JWT_TOKEN_HEADER, request);
        token = StringUtils.removeStartIgnoreCase(token, BaseContextConstants.BEARER_TOKEN);
        JwtUserInfo<Long> authJwtInfo = jwtTokenService.getAuthJwtInfo(token);
        List<String> authorities = Lists.newArrayList();
        if (authJwtInfo.isTenantStatus()) {
            authorities.add("TENANT_MANAGER");
        } else {
            String cacheKey = BuildKeyUtils.generateKey(RESOURCE_ROLES_MAP, authJwtInfo.getTenant());
            if (RoleConstant.USER_PATH.equals(routePath) || RoleConstant.USER_ROUTER_PATH.equals(routePath)) {
                authorities.add(RoleConstant.USER_CODE);
            }
            String obj = (String) redisTemplate.opsForHash().get(cacheKey, routePath);
            if (ObjectUtils.isNotEmpty(obj)) {
                List<String> stringList = ListUtils.stringToList(obj);
                authorities.addAll(stringList);
            }
        }
        authorities = authorities.stream().map(i -> i = BaseContextConstants.AUTHORITY_PREFIX + i).collect(Collectors.toList());
        //认证通过且角色匹配的用户可访问当前路径
        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
    }
}
