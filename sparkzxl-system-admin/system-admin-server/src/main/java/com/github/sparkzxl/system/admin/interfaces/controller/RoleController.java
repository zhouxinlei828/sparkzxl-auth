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
import com.github.sparkzxl.system.admin.api.model.vo.RoleVO;
import com.github.sparkzxl.system.admin.api.model.dto.RoleDTO;

import com.github.sparkzxl.system.admin.application.service.IRoleService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 角色信息 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/role")
@Api(tags = {"角色信息管理"})
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    /**
     * 角色信息分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param roleDTO: 角色信息DTO分页查询对象
     * @return Page<Role>
     */
    @ApiOperation(value = "角色信息分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<RoleVO> rolePage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody RoleDTO roleDTO) {
        return roleService.page(new Page<>(current, size), roleDTO);
    }


    /**
     * 角色信息列表查询
     *
     * @param roleDTO: 角色信息DTO列表查询对象
     * @return List<RoleVO>
     */
    @ApiOperation(value = "角色信息列表查询", httpMethod = "POST", response = RoleVO.class)
    @PostMapping("/list")
    public List<RoleVO> roleList(@RequestBody RoleDTO roleDTO) {
        return roleService.list(roleDTO);
    }

    /**
     * 角色信息详情查询
     *
     * @param id id
     * @return RoleVO
     */
    @ApiOperation(value = "角色信息详情查询", httpMethod = "GET", response = RoleVO.class)
    @GetMapping("/getById")
    public RoleVO getRoleById(@RequestParam(value="id") Long id) {
        return roleService.getById(id);
    }

    /**
     * 角色信息新增
     *
     * @param roleDTO: 角色信息新增DTO
     * @return boolean
     */
    @ApiOperation(value = "角色信息新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveRole(@Validated @RequestBody RoleDTO roleDTO) {
        return roleService.save(roleDTO);
    }


    /**
     * 角色信息修改
     *
     * @param roleDTO: 角色信息修改DTO
     * @return boolean
     */
    @ApiOperation(value = "角色信息修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateRole(@Validated @RequestBody RoleDTO roleDTO) {
        return roleService.updateById(roleDTO);
    }


    /**
     * 角色信息删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "角色信息删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return roleService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return roleService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param roleDTO 角色信息导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody RoleDTO roleDTO, HttpServletResponse response) {
        roleService.exportData(roleDTO,response);
    }

}
