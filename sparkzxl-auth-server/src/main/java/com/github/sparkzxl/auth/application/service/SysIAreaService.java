package com.github.sparkzxl.auth.application.service;

import com.github.sparkzxl.auth.infrastructure.entity.SysArea;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaQueryDTO;
import com.github.sparkzxl.database.base.service.SuperCacheService;

import java.util.List;

/**
 * description: 地区表 服务类
 *
 * @author charles.zhou
 * @date 2020-07-28 19:41:37
 */
public interface SysIAreaService extends SuperCacheService<SysArea> {

    /**
     * 查询地区信息
     *
     * @param areaQueryDTO 地区查询入参
     * @return List<Area>
     */
    List<SysArea> getAreaList(AreaQueryDTO areaQueryDTO);

    /**
     * 实时保存地区数据
     * @param subDistrict
     * @return boolean
     */
    boolean getActiveArea(Integer subDistrict);

}
