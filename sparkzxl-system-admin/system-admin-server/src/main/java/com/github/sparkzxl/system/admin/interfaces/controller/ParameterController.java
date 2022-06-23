package com.github.sparkzxl.system.admin.interfaces.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.github.sparkzxl.web.annotation.Response;

import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import com.github.sparkzxl.system.admin.api.model.vo.ParameterVO;
import com.github.sparkzxl.system.admin.api.model.dto.ParameterDTO;

import com.github.sparkzxl.system.admin.application.service.IParameterService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 系统参数 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/parameter")
@Api(tags = {"系统参数管理"})
@RequiredArgsConstructor
public class ParameterController {

    private final IParameterService parameterService;

    /**
     * 系统参数分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param parameterDTO: 系统参数DTO分页查询对象
     * @return Page<Parameter>
     */
    @ApiOperation(value = "系统参数分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<ParameterVO> parameterPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody ParameterDTO parameterDTO) {
        return parameterService.page(new Page<>(current, size), parameterDTO);
    }


    /**
     * 系统参数列表查询
     *
     * @param parameterDTO: 系统参数DTO列表查询对象
     * @return List<ParameterVO>
     */
    @ApiOperation(value = "系统参数列表查询", httpMethod = "POST", response = ParameterVO.class)
    @PostMapping("/list")
    public List<ParameterVO> parameterList(@RequestBody ParameterDTO parameterDTO) {
        return parameterService.list(parameterDTO);
    }

    /**
     * 系统参数详情查询
     *
     * @param id id
     * @return ParameterVO
     */
    @ApiOperation(value = "系统参数详情查询", httpMethod = "GET", response = ParameterVO.class)
    @GetMapping("/getById")
    public ParameterVO getParameterById(@RequestParam(value="id") Long id) {
        return parameterService.getById(id);
    }

    /**
     * 系统参数新增
     *
     * @param parameterDTO: 系统参数新增DTO
     * @return boolean
     */
    @ApiOperation(value = "系统参数新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveParameter(@Validated @RequestBody ParameterDTO parameterDTO) {
        return parameterService.save(parameterDTO);
    }


    /**
     * 系统参数修改
     *
     * @param parameterDTO: 系统参数修改DTO
     * @return boolean
     */
    @ApiOperation(value = "系统参数修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateParameter(@Validated @RequestBody ParameterDTO parameterDTO) {
        return parameterService.updateById(parameterDTO);
    }


    /**
     * 系统参数删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "系统参数删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return parameterService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return parameterService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param parameterDTO 系统参数导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody ParameterDTO parameterDTO, HttpServletResponse response) {
        parameterService.exportData(parameterDTO,response);
    }

}
