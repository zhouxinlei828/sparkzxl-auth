package com.github.sparkzxl.auth.application.service;


import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.auth.interfaces.dto.station.StationQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.station.StationSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.station.StationUpdateDTO;
import com.github.sparkzxl.database.base.service.SuperCacheService;
import com.github.sparkzxl.database.dto.PageParams;

import java.util.List;

/**
 * description: 岗位 服务类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:32:55
 */
public interface ICoreStationService extends SuperCacheService<CoreStation> {

    /**
     * 查询岗位列表
     *
     * @param params 岗位分页查询对象
     * @return PageInfo<CoreStation>
     */
    PageInfo<CoreStation> getStationPageList(PageParams<StationQueryDTO> params);

    /**
     * 新增岗位
     *
     * @param stationSaveDTO 岗位保存对象
     * @return boolean
     */
    boolean saveCoreStation(StationSaveDTO stationSaveDTO);

    /**
     * 修改岗位
     *
     * @param stationUpdateDTO 岗位更新对象
     * @return boolean
     */
    boolean updateCoreStation(StationUpdateDTO stationUpdateDTO);

    /**
     * 根据名称查询岗位信息
     *
     * @param stationName 岗位名称
     * @return CoreStation
     */
    CoreStation getCoreStationByName(String stationName);

    /**
     * 删除岗位
     *
     * @param ids 岗位ids
     * @return boolean
     */
    boolean deleteCoreStation(List<Long> ids);
}
