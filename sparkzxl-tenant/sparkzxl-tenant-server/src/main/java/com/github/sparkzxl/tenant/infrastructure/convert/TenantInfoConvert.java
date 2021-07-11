package com.github.sparkzxl.tenant.infrastructure.convert;

import com.github.sparkzxl.tenant.api.dto.TenantInfoVO;
import com.github.sparkzxl.tenant.infrastructure.entity.TenantInfo;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoSaveDTO;
import com.github.sparkzxl.tenant.interfaces.dto.tenant.TenantInfoUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * description: TenantInfoConvert 对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface TenantInfoConvert {

    TenantInfoConvert INSTANCE = Mappers.getMapper(TenantInfoConvert.class);

    /**
     * tenantSaveDTO转换为TenantInfo
     *
     * @param tenantInfoSaveDTO 租户信息保存对象
     * @return TenantInfo
     */
    TenantInfo convertTenantInfo(TenantInfoSaveDTO tenantInfoSaveDTO);

    /**
     * tenantUpdateDTO转换为TenantInfo
     *
     * @param tenantInfoUpdateDTO 租户信息更新对象
     * @return TenantInfo
     */
    TenantInfo convertTenantInfo(TenantInfoUpdateDTO tenantInfoUpdateDTO);

    /**
     * tenantInfo转换为TenantInfoVO
     *
     * @param tenantInfos 租户信息
     * @return TenantInfoVO
     */
    List<TenantInfoVO> convertTenantInfoVO(List<TenantInfo> tenantInfos);
}
