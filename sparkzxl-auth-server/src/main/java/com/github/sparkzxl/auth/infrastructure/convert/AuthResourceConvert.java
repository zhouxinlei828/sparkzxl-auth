package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.auth.interfaces.dto.resource.ResourceUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: AuthResource 对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface AuthResourceConvert {

    AuthResourceConvert INSTANCE = Mappers.getMapper(AuthResourceConvert.class);

    /**
     * authResourceUpdateDTO 转化为 AuthResource
     *
     * @param authResourceUpdateDTO 资源更新DTO
     * @return AuthResourceDTO
     */
    AuthResource convertAuthResourceDTO(ResourceUpdateDTO authResourceUpdateDTO);

}
