package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Station;
import com.github.sparkzxl.system.admin.api.model.dto.StationDTO;
import com.github.sparkzxl.system.admin.api.model.vo.StationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 岗位信息 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface StationConvert {

    StationConvert INSTANCE = Mappers.getMapper(StationConvert.class);

    /**
     * stationDTO转换为Station
     *
     * @param stationDTO 岗位信息DTO对象
     * @return Station
     */
    Station convertStation(StationDTO stationDTO);

    /**
     * Station转换为StationVO
     *
     * @param station 岗位信息DTO对象
     * @return StationVO
     */
    StationVO convertStationVO(Station station);

    /**
     * station列表转换为StationVO列表
     *
     * @param stationList 岗位信息列表
     * @return List<StationVO>
     */
    List<StationVO> convertStationVOList(List<Station> stationList);

    /**
     * 岗位信息分页对象转换为StationVO分页对象
     *
     * @param stationPage 岗位信息分页对象
     * @return Page<StationVO>
     */
    Page<StationVO> convertStationPageVO(Page<Station> stationPage);
}
