package com.github.sparkzxl.gateway.infrastructure.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.net.URI;
import java.util.LinkedHashSet;

import static org.springframework.cloud.gateway.filter.headers.XForwardedHeadersFilter.X_FORWARDED_PREFIX_HEADER;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

/**
 * description: SwaggerXForwardedHeadersFilter
 *
 * @author charles.zhou
 * @date 2020-05-24 12:14:52
 */
@Component
public class SwaggerForwardedHeadersFilter implements HttpHeadersFilter, Ordered {

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public boolean supports(Type type) {
        return true;
    }

    @Override
    public HttpHeaders filter(HttpHeaders input, ServerWebExchange exchange) {
        HttpHeaders updated = new HttpHeaders();
        input.forEach(updated::addAll);
        LinkedHashSet<URI> originalUris = exchange.getAttribute(GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        URI requestUri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);
        if (originalUris != null && requestUri != null) {
            originalUris.forEach(originalUri -> {
                if (originalUri != null && originalUri.getPath() != null) {
                    String prefix;
                    String originalUriPath = stripTrailingSlash(originalUri);
                    String requestUriPath = stripTrailingSlash(requestUri);
                    if (requestUriPath != null && (originalUriPath.endsWith(requestUriPath))) {
                        prefix = originalUriPath.replace(requestUriPath, "");
                        if (prefix.length() > 0 && prefix.length() <= originalUri.getPath().length()) {
                            updated.set(X_FORWARDED_PREFIX_HEADER, serverProperties.getServlet().getContextPath() + prefix);
                        }
                    }
                }
            });
        }

        return updated;
    }

    private String stripTrailingSlash(URI uri) {
        if (uri.getPath().endsWith("/")) {
            return uri.getPath().substring(0, uri.getPath().length() - 1);
        } else {
            return uri.getPath();
        }
    }
}
