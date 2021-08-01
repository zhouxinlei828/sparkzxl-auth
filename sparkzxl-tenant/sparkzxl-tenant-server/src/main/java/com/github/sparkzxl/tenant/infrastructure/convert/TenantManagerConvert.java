package com.github.sparkzxl.tenant.infrastructure.convert;

import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantManager;
import com.github.sparkzxl.tenant.interfaces.dto.manager.TenantManagerSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: tenantManager对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface TenantManagerConvert {

    TenantManagerConvert INSTANCE = Mappers.getMapper(TenantManagerConvert.class);

    /**
     * tenantManagerSaveDTO转换 tenantManager
     *
     * @param tenantManagerSaveDTO 领域管理员保存对象
     * @return tenantManager
     */
    TenantManager convertTenantManager(TenantManagerSaveDTO tenantManagerSaveDTO);

    /**
     * 转换用户信息
     *
     * @param tenantManager 租户管理员
     * @return AuthUserInfo<Long>
     */
    AuthUserInfo<Long> convertAuthUserInfo(TenantManager tenantManager);
}
