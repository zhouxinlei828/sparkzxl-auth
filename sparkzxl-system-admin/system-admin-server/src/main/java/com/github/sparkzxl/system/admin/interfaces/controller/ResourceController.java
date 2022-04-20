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
import com.github.sparkzxl.system.admin.api.model.vo.ResourceVO;
import com.github.sparkzxl.system.admin.api.model.dto.ResourceDTO;

import com.github.sparkzxl.system.admin.application.service.IResourceService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 资源信息 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/resource")
@Api(tags = {"资源信息管理"})
@RequiredArgsConstructor
public class ResourceController {

    private final IResourceService resourceService;

    /**
     * 资源信息分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param resourceDTO: 资源信息DTO分页查询对象
     * @return Page<Resource>
     */
    @ApiOperation(value = "资源信息分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<ResourceVO> resourcePage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody ResourceDTO resourceDTO) {
        return resourceService.page(new Page<>(current, size), resourceDTO);
    }


    /**
     * 资源信息列表查询
     *
     * @param resourceDTO: 资源信息DTO列表查询对象
     * @return List<ResourceVO>
     */
    @ApiOperation(value = "资源信息列表查询", httpMethod = "POST", response = ResourceVO.class)
    @PostMapping("/list")
    public List<ResourceVO> resourceList(@RequestBody ResourceDTO resourceDTO) {
        return resourceService.list(resourceDTO);
    }

    /**
     * 资源信息详情查询
     *
     * @param id id
     * @return ResourceVO
     */
    @ApiOperation(value = "资源信息详情查询", httpMethod = "GET", response = ResourceVO.class)
    @GetMapping("/getById")
    public ResourceVO getResourceById(@RequestParam(value="id") Long id) {
        return resourceService.getById(id);
    }

    /**
     * 资源信息新增
     *
     * @param resourceDTO: 资源信息新增DTO
     * @return boolean
     */
    @ApiOperation(value = "资源信息新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveResource(@Validated @RequestBody ResourceDTO resourceDTO) {
        return resourceService.save(resourceDTO);
    }


    /**
     * 资源信息修改
     *
     * @param resourceDTO: 资源信息修改DTO
     * @return boolean
     */
    @ApiOperation(value = "资源信息修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateResource(@Validated @RequestBody ResourceDTO resourceDTO) {
        return resourceService.updateById(resourceDTO);
    }


    /**
     * 资源信息删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "资源信息删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return resourceService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return resourceService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param resourceDTO 资源信息导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody ResourceDTO resourceDTO, HttpServletResponse response) {
        resourceService.exportData(resourceDTO,response);
    }

}
