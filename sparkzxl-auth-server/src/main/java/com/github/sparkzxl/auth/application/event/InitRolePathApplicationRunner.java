package com.github.sparkzxl.auth.application.event;

import com.github.sparkzxl.auth.application.service.IRoleAuthorityService;
import com.github.sparkzxl.auth.infrastructure.client.TenantClient;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.tenant.api.dto.TenantInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 初始化角色资源加载类
 *
 * @author charles.zhou
 * @date 2020-08-02 22:10:40
 */
@Component
public class InitRolePathApplicationRunner implements CommandLineRunner, Ordered {

    private IRoleAuthorityService roleAuthorityService;
    private TenantClient tenantClient;

    @Autowired
    public void setRoleAuthorityService(IRoleAuthorityService roleAuthorityService) {
        this.roleAuthorityService = roleAuthorityService;
    }

    @Autowired
    public void setTenantClient(TenantClient tenantClient) {
        this.tenantClient = tenantClient;
    }

    @Override
    public void run(String... args) {
        List<TenantInfoVO> tenantInfoList = tenantClient.getTenantInfoList();
        List<String> tenantIdList = tenantInfoList.stream().map(TenantInfoVO::getCode).collect(Collectors.toList());
        tenantIdList.forEach(tenantId -> {
            BaseContextHolder.setTenant("hz");
            roleAuthorityService.refreshAuthorityList();
        });
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
