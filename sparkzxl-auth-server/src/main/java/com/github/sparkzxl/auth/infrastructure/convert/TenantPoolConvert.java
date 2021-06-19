package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.infrastructure.entity.TenantPool;
import com.github.sparkzxl.auth.interfaces.dto.tenant.TenantPoolSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.tenant.TenantPoolUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: TenantPoolConvert 对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface TenantPoolConvert {

    TenantPoolConvert INSTANCE = Mappers.getMapper(TenantPoolConvert.class);

    /**
     * tenantSaveDTO转换为TenantPool
     *
     * @param tenantPoolSaveDTO 租户池保存对象
     * @return TenantPool
     */
    TenantPool convertTenantPool(TenantPoolSaveDTO tenantPoolSaveDTO);

    /**
     * tenantUpdateDTO转换为TenantPool
     *
     * @param tenantPoolUpdateDTO 租户池更新对象
     * @return TenantPool
     */
    TenantPool convertTenantPool(TenantPoolUpdateDTO tenantPoolUpdateDTO);
}
