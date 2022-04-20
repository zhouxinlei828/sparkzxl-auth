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
import com.github.sparkzxl.system.admin.api.model.vo.RoleAuthorityVO;
import com.github.sparkzxl.system.admin.api.model.dto.RoleAuthorityDTO;

import com.github.sparkzxl.system.admin.application.service.IRoleAuthorityService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 角色的资源 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/role-authority")
@Api(tags = {"角色的资源管理"})
@RequiredArgsConstructor
public class RoleAuthorityController {

    private final IRoleAuthorityService roleAuthorityService;

    /**
     * 角色的资源分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param roleAuthorityDTO: 角色的资源DTO分页查询对象
     * @return Page<RoleAuthority>
     */
    @ApiOperation(value = "角色的资源分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<RoleAuthorityVO> roleAuthorityPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody RoleAuthorityDTO roleAuthorityDTO) {
        return roleAuthorityService.page(new Page<>(current, size), roleAuthorityDTO);
    }


    /**
     * 角色的资源列表查询
     *
     * @param roleAuthorityDTO: 角色的资源DTO列表查询对象
     * @return List<RoleAuthorityVO>
     */
    @ApiOperation(value = "角色的资源列表查询", httpMethod = "POST", response = RoleAuthorityVO.class)
    @PostMapping("/list")
    public List<RoleAuthorityVO> roleAuthorityList(@RequestBody RoleAuthorityDTO roleAuthorityDTO) {
        return roleAuthorityService.list(roleAuthorityDTO);
    }

    /**
     * 角色的资源详情查询
     *
     * @param id id
     * @return RoleAuthorityVO
     */
    @ApiOperation(value = "角色的资源详情查询", httpMethod = "GET", response = RoleAuthorityVO.class)
    @GetMapping("/getById")
    public RoleAuthorityVO getRoleAuthorityById(@RequestParam(value="id") Long id) {
        return roleAuthorityService.getById(id);
    }

    /**
     * 角色的资源新增
     *
     * @param roleAuthorityDTO: 角色的资源新增DTO
     * @return boolean
     */
    @ApiOperation(value = "角色的资源新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveRoleAuthority(@Validated @RequestBody RoleAuthorityDTO roleAuthorityDTO) {
        return roleAuthorityService.save(roleAuthorityDTO);
    }


    /**
     * 角色的资源修改
     *
     * @param roleAuthorityDTO: 角色的资源修改DTO
     * @return boolean
     */
    @ApiOperation(value = "角色的资源修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateRoleAuthority(@Validated @RequestBody RoleAuthorityDTO roleAuthorityDTO) {
        return roleAuthorityService.updateById(roleAuthorityDTO);
    }


    /**
     * 角色的资源删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "角色的资源删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return roleAuthorityService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return roleAuthorityService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param roleAuthorityDTO 角色的资源导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody RoleAuthorityDTO roleAuthorityDTO, HttpServletResponse response) {
        roleAuthorityService.exportData(roleAuthorityDTO,response);
    }

}
