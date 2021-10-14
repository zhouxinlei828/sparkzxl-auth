package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.infrastructure.client.result.Area;
import com.github.sparkzxl.auth.infrastructure.entity.SysArea;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: SysArea 对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface SysAreaConvert {

    SysAreaConvert INSTANCE = Mappers.getMapper(SysAreaConvert.class);

    /**
     * Area转换为SysArea
     *
     * @param area 地区
     * @return AuthMenu
     */
    SysArea convertSysArea(Area area);
}
