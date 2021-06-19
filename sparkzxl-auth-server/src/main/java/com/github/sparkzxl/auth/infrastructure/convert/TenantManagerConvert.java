package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.domain.model.aggregates.AuthUserBasicInfo;
import com.github.sparkzxl.auth.infrastructure.entity.TenantManager;
import com.github.sparkzxl.auth.interfaces.dto.manager.TenantManagerSaveDTO;
import com.github.sparkzxl.core.entity.AuthUserInfo;
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
     * AuthUser转化为AuthUserInfo
     *
     * @param tenantManager 领域用户
     * @return AuthUserInfo
     */
    AuthUserInfo<Long> convertAuthUserInfo(TenantManager tenantManager);


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
     * @param tenantManager 领域管理员
     * @return AuthUserBasicInfo
     */
    AuthUserBasicInfo convertAuthUserBasicInfo(TenantManager tenantManager);

}
