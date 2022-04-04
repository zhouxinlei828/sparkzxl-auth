package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.domain.model.vo.AreaTree;
import com.github.sparkzxl.auth.interfaces.client.result.Area;
import com.github.sparkzxl.auth.infrastructure.entity.SysArea;
import com.github.sparkzxl.auth.domain.model.dto.area.AreaSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.area.AreaUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
     * @return SysArea
     */
    SysArea convertSysArea(Area area);

    /**
     * AreaUpdateDTO转换为SysArea
     *
     * @param area 地区
     * @return SysArea
     */
    @Mappings({
            @Mapping(source = "id", target = "code"),
            @Mapping(source = "parentId", target = "parentCode"),
            @Mapping(source = "label", target = "name"),
    })
    SysArea convertSysArea(AreaSaveDTO area);

    /**
     * AreaUpdateDTO转换为SysArea
     *
     * @param area 地区
     * @return SysArea
     */
    @Mappings({
            @Mapping(source = "id", target = "code"),
            @Mapping(source = "label", target = "name"),
            @Mapping(source = "parentId", target = "parentCode"),
    })
    SysArea convertSysArea(AreaUpdateDTO area);

    /**
     * SysArea转换为AreaTree
     *
     * @param area 地区
     * @return AreaTree
     */
    @Mappings({
            @Mapping(source = "code", target = "id"),
            @Mapping(source = "name", target = "label"),
            @Mapping(source = "parentCode", target = "parentId"),
    })
    AreaTree convertSysArea(SysArea area);

    /**
     * SysArea转换为AreaTree列表
     *
     * @param areaList 地区
     * @return List<AreaTree>
     */
    List<AreaTree> convertSysAreaList(List<SysArea> areaList);
}
