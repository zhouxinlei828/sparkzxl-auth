package com.github.sparkzxl.tenant.api;

import com.github.sparkzxl.tenant.api.dto.TenantInfoVO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * description: 租户api
 *
 * @author zhouxinlei
 * @date 2021-07-11 09:04:23
 */
public interface TenantApi {

    /**
     * 查询租户列表
     *
     * @return List<TenantInfoVO>
     */
    @GetMapping("/list")
    List<TenantInfoVO> getTenantInfoList();
}
