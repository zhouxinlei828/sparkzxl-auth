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
import com.github.sparkzxl.system.admin.api.model.vo.UserRoleVO;
import com.github.sparkzxl.system.admin.api.model.dto.UserRoleDTO;

import com.github.sparkzxl.system.admin.application.service.IUserRoleService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 角色分配	账号角色绑定 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/user-role")
@Api(tags = {"角色分配	账号角色绑定管理"})
@RequiredArgsConstructor
public class UserRoleController {

    private final IUserRoleService userRoleService;

    /**
     * 角色分配	账号角色绑定分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param userRoleDTO: 角色分配	账号角色绑定DTO分页查询对象
     * @return Page<UserRole>
     */
    @ApiOperation(value = "角色分配	账号角色绑定分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<UserRoleVO> userRolePage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody UserRoleDTO userRoleDTO) {
        return userRoleService.page(new Page<>(current, size), userRoleDTO);
    }


    /**
     * 角色分配	账号角色绑定列表查询
     *
     * @param userRoleDTO: 角色分配	账号角色绑定DTO列表查询对象
     * @return List<UserRoleVO>
     */
    @ApiOperation(value = "角色分配	账号角色绑定列表查询", httpMethod = "POST", response = UserRoleVO.class)
    @PostMapping("/list")
    public List<UserRoleVO> userRoleList(@RequestBody UserRoleDTO userRoleDTO) {
        return userRoleService.list(userRoleDTO);
    }

    /**
     * 角色分配	账号角色绑定详情查询
     *
     * @param id id
     * @return UserRoleVO
     */
    @ApiOperation(value = "角色分配	账号角色绑定详情查询", httpMethod = "GET", response = UserRoleVO.class)
    @GetMapping("/getById")
    public UserRoleVO getUserRoleById(@RequestParam(value="id") Long id) {
        return userRoleService.getById(id);
    }

    /**
     * 角色分配	账号角色绑定新增
     *
     * @param userRoleDTO: 角色分配	账号角色绑定新增DTO
     * @return boolean
     */
    @ApiOperation(value = "角色分配	账号角色绑定新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveUserRole(@Validated @RequestBody UserRoleDTO userRoleDTO) {
        return userRoleService.save(userRoleDTO);
    }


    /**
     * 角色分配	账号角色绑定修改
     *
     * @param userRoleDTO: 角色分配	账号角色绑定修改DTO
     * @return boolean
     */
    @ApiOperation(value = "角色分配	账号角色绑定修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateUserRole(@Validated @RequestBody UserRoleDTO userRoleDTO) {
        return userRoleService.updateById(userRoleDTO);
    }


    /**
     * 角色分配	账号角色绑定删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "角色分配	账号角色绑定删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return userRoleService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return userRoleService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param userRoleDTO 角色分配	账号角色绑定导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody UserRoleDTO userRoleDTO, HttpServletResponse response) {
        userRoleService.exportData(userRoleDTO,response);
    }

}
