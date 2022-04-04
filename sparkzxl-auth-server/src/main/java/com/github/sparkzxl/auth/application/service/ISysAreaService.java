package com.github.sparkzxl.auth.application.service;

import com.github.sparkzxl.auth.domain.model.vo.AreaTree;
import com.github.sparkzxl.auth.infrastructure.entity.SysArea;
import com.github.sparkzxl.auth.domain.model.dto.area.AreaQueryDTO;
import com.github.sparkzxl.auth.domain.model.dto.area.AreaSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.area.AreaUpdateDTO;
import com.github.sparkzxl.database.base.service.SuperService;

import java.util.List;

/**
 * description: 地区表 服务类
 *
 * @author charles.zhou
 * @date 2020-07-28 19:41:37
 */
public interface ISysAreaService extends SuperService<SysArea> {

    /**
     * 查询地区信息
     *
     * @param areaQueryDTO 地区查询入参
     * @return List<AreaTree>
     */
    List<AreaTree> getAreaList(AreaQueryDTO areaQueryDTO);

    /**
     * 实时保存地区数据
     *
     * @param subDistrict 设置显示下级行政区级数（行政区级别包括：国家、省/直辖市、市、区/县、乡镇/街道多级数据）
     *                    可选值：0、1、2、3等数字，并以此类推
     * @return boolean
     */
    boolean getActiveArea(Integer subDistrict);

    /**
     * 更新地区信息
     *
     * @param updateDTO 地区更新入参
     * @return boolean
     */
    boolean updateArea(AreaUpdateDTO updateDTO);

    /**
     * 新增地区信息
     *
     * @param saveDTO 地区保存入参
     * @return boolean
     */
    boolean saveArea(AreaSaveDTO saveDTO);
}
