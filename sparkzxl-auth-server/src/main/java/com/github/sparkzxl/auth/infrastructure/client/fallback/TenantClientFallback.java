package com.github.sparkzxl.auth.infrastructure.client.fallback;

import com.github.sparkzxl.auth.infrastructure.client.TenantClient;
import com.github.sparkzxl.feign.utils.ServiceDegradeUtils;
import com.github.sparkzxl.tenant.api.dto.TenantInfoVO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description: 租户降级处理类
 *
 * @author zhouxinlei
 * @date 2021-07-11 09:42:47
 */
@Component
public class TenantClientFallback implements TenantClient {

    @Override
    public List<TenantInfoVO> getTenantInfoList() {
        ServiceDegradeUtils.fallBack();
        return Lists.newArrayList();
    }
}
