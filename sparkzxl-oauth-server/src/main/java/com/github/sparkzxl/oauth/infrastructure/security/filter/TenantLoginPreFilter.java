package com.github.sparkzxl.oauth.infrastructure.security.filter;

import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.core.context.BaseContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: 多租户信息模式登录前置过滤器
 *
 * @author charles.zhou
 * @date 2021-02-25 10:53:03
 */
@Component
public class TenantLoginPreFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authenticationFormUrl = "/authentication/form";
        if (StringUtils.equals(request.getRequestURI(), authenticationFormUrl)) {
            String tenantId = request.getParameter(BaseContextConstants.TENANT_ID);
            BaseContextHolder.setTenant(tenantId);
        }
        chain.doFilter(request, response);
    }
}
