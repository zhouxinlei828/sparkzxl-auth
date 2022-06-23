package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.domain.model.aggregates.excel.StationExcel;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.auth.domain.model.dto.station.StationSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.station.StationUpdateDTO;
import com.github.sparkzxl.entity.data.RemoteData;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * description: CoreStation对象Convert
 *
 * @author charles.zhou
 * @since 2020-06-05 21:28:06
 */
@Mapper
public interface CoreStationConvert {

    CoreStationConvert INSTANCE = Mappers.getMapper(CoreStationConvert.class);

    /**
     * StationSaveDTO 转换为CoreStation
     *
     * @param stationSaveDTO 岗位保存对象
     * @return CoreStation
     */
    CoreStation convertCoreStation(StationSaveDTO stationSaveDTO);

    /**
     * StationUpdateDTO转换为CoreStation
     *
     * @param stationUpdateDTO 岗位更新对象
     * @return CoreStation
     */
    CoreStation convertCoreStation(StationUpdateDTO stationUpdateDTO);


    /**
     * excel 转换
     *
     * @param coreStation 岗位
     * @return StationExcel
     */
    @Mapping(target = "orgName", expression = "java(convertOrg(coreStation.getOrg()))")
    StationExcel convertUserExcel(CoreStation coreStation);


    /**
     * 批量转换
     *
     * @param stationList 岗位列表
     * @return List<StationExcel>
     */
    List<StationExcel> convertStationExcels(List<CoreStation> stationList);

    /**
     * 转换组织
     *
     * @param org 组织
     * @return String
     */
    default String convertOrg(RemoteData<Long, CoreOrg> org) {
        if (ObjectUtils.isNotEmpty(org) && ObjectUtils.isNotEmpty(org.getData())) {
            return org.getData().getLabel();
        }
        return null;
    }

}
