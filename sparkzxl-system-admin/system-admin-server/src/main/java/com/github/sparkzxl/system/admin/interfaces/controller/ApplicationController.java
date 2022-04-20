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
import com.github.sparkzxl.system.admin.api.model.vo.ApplicationVO;
import com.github.sparkzxl.system.admin.api.model.dto.ApplicationDTO;

import com.github.sparkzxl.system.admin.application.service.IApplicationService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 应用 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/application")
@Api(tags = {"应用管理"})
@RequiredArgsConstructor
public class ApplicationController {

    private final IApplicationService applicationService;

    /**
     * 应用分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param applicationDTO: 应用DTO分页查询对象
     * @return Page<Application>
     */
    @ApiOperation(value = "应用分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<ApplicationVO> applicationPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody ApplicationDTO applicationDTO) {
        return applicationService.page(new Page<>(current, size), applicationDTO);
    }


    /**
     * 应用列表查询
     *
     * @param applicationDTO: 应用DTO列表查询对象
     * @return List<ApplicationVO>
     */
    @ApiOperation(value = "应用列表查询", httpMethod = "POST", response = ApplicationVO.class)
    @PostMapping("/list")
    public List<ApplicationVO> applicationList(@RequestBody ApplicationDTO applicationDTO) {
        return applicationService.list(applicationDTO);
    }

    /**
     * 应用详情查询
     *
     * @param id id
     * @return ApplicationVO
     */
    @ApiOperation(value = "应用详情查询", httpMethod = "GET", response = ApplicationVO.class)
    @GetMapping("/getById")
    public ApplicationVO getApplicationById(@RequestParam(value="id") Long id) {
        return applicationService.getById(id);
    }

    /**
     * 应用新增
     *
     * @param applicationDTO: 应用新增DTO
     * @return boolean
     */
    @ApiOperation(value = "应用新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveApplication(@Validated @RequestBody ApplicationDTO applicationDTO) {
        return applicationService.save(applicationDTO);
    }


    /**
     * 应用修改
     *
     * @param applicationDTO: 应用修改DTO
     * @return boolean
     */
    @ApiOperation(value = "应用修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateApplication(@Validated @RequestBody ApplicationDTO applicationDTO) {
        return applicationService.updateById(applicationDTO);
    }


    /**
     * 应用删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "应用删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return applicationService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return applicationService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param applicationDTO 应用导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody ApplicationDTO applicationDTO, HttpServletResponse response) {
        applicationService.exportData(applicationDTO,response);
    }

}
