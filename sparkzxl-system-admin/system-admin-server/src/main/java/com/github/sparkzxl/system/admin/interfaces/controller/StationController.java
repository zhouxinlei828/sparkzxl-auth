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
import com.github.sparkzxl.system.admin.api.model.vo.StationVO;
import com.github.sparkzxl.system.admin.api.model.dto.StationDTO;

import com.github.sparkzxl.system.admin.application.service.IStationService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 岗位信息 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/station")
@Api(tags = {"岗位信息管理"})
@RequiredArgsConstructor
public class StationController {

    private final IStationService stationService;

    /**
     * 岗位信息分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param stationDTO: 岗位信息DTO分页查询对象
     * @return Page<Station>
     */
    @ApiOperation(value = "岗位信息分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<StationVO> stationPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody StationDTO stationDTO) {
        return stationService.page(new Page<>(current, size), stationDTO);
    }


    /**
     * 岗位信息列表查询
     *
     * @param stationDTO: 岗位信息DTO列表查询对象
     * @return List<StationVO>
     */
    @ApiOperation(value = "岗位信息列表查询", httpMethod = "POST", response = StationVO.class)
    @PostMapping("/list")
    public List<StationVO> stationList(@RequestBody StationDTO stationDTO) {
        return stationService.list(stationDTO);
    }

    /**
     * 岗位信息详情查询
     *
     * @param id id
     * @return StationVO
     */
    @ApiOperation(value = "岗位信息详情查询", httpMethod = "GET", response = StationVO.class)
    @GetMapping("/getById")
    public StationVO getStationById(@RequestParam(value="id") Long id) {
        return stationService.getById(id);
    }

    /**
     * 岗位信息新增
     *
     * @param stationDTO: 岗位信息新增DTO
     * @return boolean
     */
    @ApiOperation(value = "岗位信息新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveStation(@Validated @RequestBody StationDTO stationDTO) {
        return stationService.save(stationDTO);
    }


    /**
     * 岗位信息修改
     *
     * @param stationDTO: 岗位信息修改DTO
     * @return boolean
     */
    @ApiOperation(value = "岗位信息修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateStation(@Validated @RequestBody StationDTO stationDTO) {
        return stationService.updateById(stationDTO);
    }


    /**
     * 岗位信息删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "岗位信息删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return stationService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return stationService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param stationDTO 岗位信息导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody StationDTO stationDTO, HttpServletResponse response) {
        stationService.exportData(stationDTO,response);
    }

}
