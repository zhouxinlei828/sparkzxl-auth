package com.github.sparkzxl.system.admin.interfaces.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.github.sparkzxl.annotation.response.Response;

import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import com.github.sparkzxl.system.admin.api.model.vo.AreaVO;
import com.github.sparkzxl.system.admin.api.model.dto.AreaDTO;

import com.github.sparkzxl.system.admin.application.service.IAreaService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/area")
@Api(tags = {"地区表管理"})
@RequiredArgsConstructor
public class AreaController {

    private final IAreaService areaService;

    /**
     * 地区表分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param areaDTO: 地区表DTO分页查询对象
     * @return Page<Area>
     */
    @ApiOperation(value = "地区表分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<AreaVO> areaPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody AreaDTO areaDTO) {
        return areaService.page(new Page<>(current, size), areaDTO);
    }


    /**
     * 地区表列表查询
     *
     * @param areaDTO: 地区表DTO列表查询对象
     * @return List<AreaVO>
     */
    @ApiOperation(value = "地区表列表查询", httpMethod = "POST", response = AreaVO.class)
    @PostMapping("/list")
    public List<AreaVO> areaList(@RequestBody AreaDTO areaDTO) {
        return areaService.list(areaDTO);
    }

    /**
     * 地区表详情查询
     *
     * @param id id
     * @return AreaVO
     */
    @ApiOperation(value = "地区表详情查询", httpMethod = "GET", response = AreaVO.class)
    @GetMapping("/getById")
    public AreaVO getAreaById(@RequestParam(value="id") Long id) {
        return areaService.getById(id);
    }

    /**
     * 地区表新增
     *
     * @param areaDTO: 地区表新增DTO
     * @return boolean
     */
    @ApiOperation(value = "地区表新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveArea(@Validated @RequestBody AreaDTO areaDTO) {
        return areaService.save(areaDTO);
    }


    /**
     * 地区表修改
     *
     * @param areaDTO: 地区表修改DTO
     * @return boolean
     */
    @ApiOperation(value = "地区表修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateArea(@Validated @RequestBody AreaDTO areaDTO) {
        return areaService.updateById(areaDTO);
    }


    /**
     * 地区表删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "地区表删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return areaService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return areaService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param areaDTO 地区表导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody AreaDTO areaDTO, HttpServletResponse response) {
        areaService.exportData(areaDTO,response);
    }

}
