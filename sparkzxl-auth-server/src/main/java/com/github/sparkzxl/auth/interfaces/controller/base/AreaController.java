package com.github.sparkzxl.auth.interfaces.controller.base;


import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.auth.application.service.ISysAreaService;
import com.github.sparkzxl.auth.domain.model.vo.AreaTree;
import com.github.sparkzxl.auth.infrastructure.entity.SysArea;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: 地区管理
 *
 * @author charles.zhou
 * @date 2020-07-28 19:48:13
 */
@RestController
@Response
@Api(tags = "地区管理")
@RequestMapping("/base/area")
public class AreaController extends SuperController<ISysAreaService, Long,
        SysArea, AreaSaveDTO, AreaUpdateDTO, AreaQueryDTO, Object> {


    @ApiOperation("查询地区列表")
    @GetMapping("/tree")
    public List<AreaTree> getAreaList(AreaQueryDTO areaQueryDTO) {
        return super.baseService.getAreaList(areaQueryDTO);
    }

    @ApiOperation("实时保存地区数据")
    @GetMapping("/getActiveArea")
    public boolean getActiveArea(@RequestParam("subDistrict") Integer subDistrict) {
        return baseService.getActiveArea(subDistrict);
    }

    @Override
    public boolean save(@RequestBody @Validated AreaSaveDTO saveDTO) {
        return baseService.saveArea(saveDTO);
    }

    @Override
    public boolean update(@RequestBody @Validated AreaUpdateDTO updateDTO) {
        return baseService.updateArea(updateDTO);
    }
}
