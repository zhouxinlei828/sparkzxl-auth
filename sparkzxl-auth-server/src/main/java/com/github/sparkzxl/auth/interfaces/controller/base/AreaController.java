package com.github.sparkzxl.auth.interfaces.controller.base;


import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.auth.application.service.SysIAreaService;
import com.github.sparkzxl.auth.infrastructure.entity.SysArea;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * description: 地区管理
 *
 * @author charles.zhou
 * @date 2020-07-28 19:48:13
 */
@RestController
@ResponseResult
@Api(tags = "地区管理")
@RequestMapping("/base/area")
public class AreaController extends SuperCacheController<SysIAreaService, Long,
        SysArea, AreaSaveDTO, AreaUpdateDTO, AreaQueryDTO, Object> {


    @ApiOperation("查询地区列表")
    @GetMapping("/tree")
    public List<SysArea> getAreaList(AreaQueryDTO areaQueryDTO) {
        return super.baseService.getAreaList(areaQueryDTO);
    }

    @ApiOperation("实时保存地区数据")
    @GetMapping("/getActiveArea")
    public boolean getActiveArea(@RequestParam("subDistrict") Integer subDistrict) {
        return super.baseService.getActiveArea(subDistrict);
    }

    @ApiOperation("导入城市地区信息")
    @PostMapping("/importCity")
    public boolean importAreaJsonData(@RequestParam("jsonFile") MultipartFile multipartFile) {
        return super.baseService.importAreaJsonData(multipartFile);
    }

}
