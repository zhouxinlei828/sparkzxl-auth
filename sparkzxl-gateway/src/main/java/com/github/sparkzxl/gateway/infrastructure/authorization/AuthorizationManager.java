package com.github.sparkzxl.gateway.infrastructure.authorization;

import cn.hutool.core.convert.Convert;
import com.github.sparkzxl.core.context.BaseContextConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.data.redis.core.RedisTemplate;
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
 * @date   2020-08-02 18:00:02
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

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        //从Redis中获取当前路径可访问角色列表
        URI uri = authorizationContext.getExchange().getRequest().getURI();
        final String[] path = {uri.getPath()};
        gatewayProperties.getRoutes().forEach(route -> {
            String prefix = serverProperties.getServlet().getContextPath().concat("/").concat(route.getId());
            path[0] = path[0].replace(prefix, "");
        });
        String routePath = path[0];
        Object obj = redisTemplate.opsForHash().get(RESOURCE_ROLES_MAP, routePath);
        List<String> authorities = Convert.toList(String.class, obj);
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
