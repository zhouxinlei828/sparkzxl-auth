package com.github.sparkzxl.gateway.infrastructure.rule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceInstance;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.ExtendBalancer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.gateway.rule.ILoadBalancerRule;
import com.github.sparkzxl.gateway.util.ReactorHttpHelper;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * description: 灰度版本负载均衡
 *
 * @author zhoux
 * @date 2021-10-23 16:45:51
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class GrayVersionLoadBalancer implements ILoadBalancerRule {

    private final NacosDiscoveryProperties nacosDiscoveryProperties;
    private final NacosServiceManager nacosServiceManager;

    private final static String SECURE = "secure";

    @Override
    public ServiceInstance chooseInstance(String serviceId, ServerHttpRequest request) {
        try {
            String clusterName = nacosDiscoveryProperties.getClusterName();
            String group = nacosDiscoveryProperties.getGroup();
            NamingService namingService = nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());
            List<Instance> instances = namingService.selectInstances(serviceId, group, true);
            if (CollectionUtils.isEmpty(instances)) {
                log.warn("no instance in service {}", serviceId);
                return null;
            } else {
                List<Instance> instancesToChoose = instances;
                if (StringUtils.isNotBlank(clusterName)) {
                    List<Instance> sameClusterInstances = instances.stream().filter((instance) -> Objects.equals(clusterName, instance.getClusterName())).collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(sameClusterInstances)) {
                        instancesToChoose = sameClusterInstances;
                    } else {
                        log.warn("A cross-cluster call occurs，name = {}, clusterName = {}, instance = {}", serviceId, clusterName, instances);
                    }
                }
                List<Instance> targetInstanceList = Lists.newArrayList();
                String version = ReactorHttpHelper.getHeader(BaseContextConstants.VERSION, request);
                // 判断版本号是否存在
                if (StringUtils.isNotBlank(version)) {
                    //取指定版本号的实例
                    targetInstanceList = instancesToChoose.stream().filter(instance -> version.equals(instance.getMetadata().get(BaseContextConstants.VERSION)))
                            .collect(Collectors.toList());
                }
                if (CollectionUtils.isEmpty(targetInstanceList)) {
                    //只取无版本号的实例
                    targetInstanceList = instancesToChoose.stream().filter(instance -> StringUtils.isEmpty(instance.getMetadata().get(BaseContextConstants.VERSION)))
                            .collect(Collectors.toList());
                }
                if (CollectionUtils.isEmpty(targetInstanceList)) {
                    // 取所有的实例
                    targetInstanceList = instancesToChoose;
                }
                Instance instance = ExtendBalancer.getHostByRandomWeight2(targetInstanceList);
                NacosServiceInstance nacosServiceInstance = new NacosServiceInstance();
                Map<String, String> metadata = instance.getMetadata();
                nacosServiceInstance.setHost(instance.getIp());
                nacosServiceInstance.setPort(instance.getPort());
                nacosServiceInstance.setServiceId(instance.getInstanceId());
                nacosServiceInstance.setMetadata(metadata);
                if (metadata.containsKey(SECURE)) {
                    boolean secure = Boolean.parseBoolean(metadata.get(SECURE));
                    nacosServiceInstance.setSecure(secure);
                }
                log.warn("request instance name = {}, version = {}, IP = {}", serviceId, version, instance.getIp().concat(":").concat(String.valueOf(instance.getPort())));
                return nacosServiceInstance;

            }
        } catch (NacosException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String name() {
        return "grayVersion";
    }
}
