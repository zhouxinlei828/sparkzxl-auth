package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Area;
import com.github.sparkzxl.system.admin.api.model.dto.AreaDTO;
import com.github.sparkzxl.system.admin.api.model.vo.AreaVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 地区表 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface AreaConvert {

    AreaConvert INSTANCE = Mappers.getMapper(AreaConvert.class);

    /**
     * areaDTO转换为Area
     *
     * @param areaDTO 地区表DTO对象
     * @return Area
     */
    Area convertArea(AreaDTO areaDTO);

    /**
     * Area转换为AreaVO
     *
     * @param area 地区表DTO对象
     * @return AreaVO
     */
    AreaVO convertAreaVO(Area area);

    /**
     * area列表转换为AreaVO列表
     *
     * @param areaList 地区表列表
     * @return List<AreaVO>
     */
    List<AreaVO> convertAreaVOList(List<Area> areaList);

    /**
     * 地区表分页对象转换为AreaVO分页对象
     *
     * @param areaPage 地区表分页对象
     * @return Page<AreaVO>
     */
    Page<AreaVO> convertAreaPageVO(Page<Area> areaPage);
}
