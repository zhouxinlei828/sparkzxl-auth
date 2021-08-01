package com.github.sparkzxl.tenant.infrastructure.mapper;

import com.github.sparkzxl.database.base.mapper.SuperMapper;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantInfo;
import org.springframework.stereotype.Repository;

/**
 * description: 租户信息 Mapper 接口
 *
 * @author charles.zhou
 * @date 2021-02-02 16:09:50
 */
@Repository
public interface TenantInfoMapper extends SuperMapper<TenantInfo> {

}
