
package com.github.sparkzxl.gateway.infrastructure.config;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;

/**
 * description: 资源配置
 *
 * @author charles.zhou
 * @date 2020-05-24 12:16:52
 */
@Component
@Primary
@Slf4j
public class SwaggerResourceConfig implements SwaggerResourcesProvider {

    @Autowired
    RouteLocator routeLocator;

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Autowired
    private GatewayProperties gatewayProperties;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public List<SwaggerResource> get() {
        String url = "/swagger-resources";
        //获取所有router
        List<SwaggerResource> resources = Lists.newArrayList();

        List<String> routes = Lists.newArrayList();
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        gatewayProperties.getRoutes().stream()
                .filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(route -> {
                    route.getPredicates().stream()
                            .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                            .forEach(predicateDefinition -> {
                                        try {
                                            JSONArray list = restTemplate.getForObject("http://" + route.getUri().getHost() + url, JSONArray.class);
                                            assert list != null;
                                            if (!list.isEmpty()) {
                                                for (int i = 0; i < list.size(); i++) {
                                                    SwaggerResource sr = list.getObject(i, SwaggerResource.class);
                                                    resources.add(swaggerResource(sr.getName(), "/" + route.getId() + sr.getUrl()));
                                                }
                                            }
                                        } catch (Exception e) {
                                            log.warn("加载后端资源时失败{}", route.getUri().getHost());
                                        }
                                    }

                            );
                });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        log.info("name:{},location:{}", name, location);
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
