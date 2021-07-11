package com.github.sparkzxl.auth.infrastructure.client;

import com.github.sparkzxl.auth.infrastructure.client.fallback.TenantClientFallback;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.tenant.api.TenantApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * description: 租户client
 *
 * @author zhouxinlei
 * @date 2021-07-11 09:51:44
 */
@FeignClient(name = BizConstant.TENANT_SERVICE_, path = "/tenant/info", fallback = TenantClientFallback.class, qualifier = "tenantClient")
public interface TenantClient extends TenantApi {
}
