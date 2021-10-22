package com.github.sparkzxl.gateway.infrastructure.rule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceInstance;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.ExtendBalancer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class RouteVersionLoadBalancer implements RouteLoadBalancer {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Autowired
    private NacosServiceManager nacosServiceManager;

    @Override
    public ServiceInstance choose(String serviceId, ServerHttpRequest request) {
        try {
            String clusterName = this.nacosDiscoveryProperties.getClusterName();
            String group = this.nacosDiscoveryProperties.getGroup();
            String name = serviceId;
            NamingService namingService = this.nacosServiceManager.getNamingService(this.nacosDiscoveryProperties.getNacosProperties());
            List<Instance> instances = namingService.selectInstances(name, group, true);
            if (CollectionUtils.isEmpty(instances)) {
                log.warn("no instance in service {}", name);
                return null;
            } else {
                List<Instance> instancesToChoose = instances;
                if (StringUtils.isNotBlank(clusterName)) {
                    List<Instance> sameClusterInstances = instances.stream().filter((instance) -> Objects.equals(clusterName, instance.getClusterName())).collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(sameClusterInstances)) {
                        instancesToChoose = sameClusterInstances;
                    } else {
                        log.warn("A cross-cluster call occurs，name = {}, clusterName = {}, instance = {}", name, clusterName, instances);
                    }
                }
                List<Instance> targetInstanceList = Lists.newArrayList();
                String version = BaseContextHolder.getVersion();
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
                if (metadata.containsKey("secure")) {
                    boolean secure = Boolean.parseBoolean(metadata.get("secure"));
                    nacosServiceInstance.setSecure(secure);
                }
                log.warn("请求实例名 = {}, version = {}, instance = {}", name, version, instance.getIp().concat(":").concat(String.valueOf(instance.getPort())));
                return nacosServiceInstance;

            }
        } catch (NacosException e) {
            e.printStackTrace();
        }

        return null;
    }
}
