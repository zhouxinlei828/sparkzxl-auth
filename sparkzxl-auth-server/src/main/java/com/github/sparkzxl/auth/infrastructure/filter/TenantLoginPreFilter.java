package com.github.sparkzxl.auth.infrastructure.filter;

import com.github.sparkzxl.core.context.BaseContextHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: 多领域池模式登录前置过滤器
 *
 * @author charles.zhou
 * @date   2021-02-25 10:53:03
 */
@Component
public class TenantLoginPreFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authenticationFormUrl = "/authentication/form";
        if (StringUtils.equals(request.getRequestURI(), authenticationFormUrl)) {
            String RealmCode = request.getParameter("RealmCode");
            BaseContextHandler.setRealm(RealmCode);
        }
        chain.doFilter(request, response);
    }
}
