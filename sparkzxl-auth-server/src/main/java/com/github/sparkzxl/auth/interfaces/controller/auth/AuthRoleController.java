package com.github.sparkzxl.auth.interfaces.controller.auth;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.auth.application.service.IRoleService;
import com.github.sparkzxl.auth.application.service.IUserRoleService;
import com.github.sparkzxl.auth.domain.model.vo.RoleResourceVO;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.interfaces.dto.role.*;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: 角色 前端控制器
 *
 * @author charles.zhou
 * @date 2020-06-07 13:40:03
 */
@RestController
@RequestMapping("/role")
@Response
@HttpRequestLog
@Api(tags = "角色管理")
public class AuthRoleController extends SuperCacheController<IRoleService, Long,
        AuthRole, RoleSaveDTO, RoleUpdateDTO, RoleQueryDTO, Object> {

    private IUserRoleService userRoleService;

    @Autowired
    public void setUserRoleService(IUserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public PageInfo<AuthRole> page(PageParams<RoleQueryDTO> params) {
        return baseService.getPageList(params);
    }

    @Override
    public boolean save(RoleSaveDTO roleSaveDTO) {
        return baseService.saveRole(roleSaveDTO);
    }

    @Override
    public boolean update(RoleUpdateDTO roleUpdateDTO) {
        return baseService.updateRole(roleUpdateDTO);
    }

    @Override
    public boolean handlerDelete(List<Long> ids) {
        baseService.deleteAuthRoleRelation(ids);
        return true;
    }

    @ApiOperation("更新角色状态")
    @PatchMapping("/role/{id}")
    public boolean updateAuthRoleStatus(@PathVariable("id") Long id,
                                        @RequestParam(value = "status") Boolean status) {
        return baseService.updateAuthRoleStatus(id, status);
    }

    @ApiOperation("保存角色用户")
    @PostMapping("/user/save")
    public boolean saveAuthRoleUser(@Validated @RequestBody RoleUserSaveDTO roleUserSaveDTO) {
        return userRoleService.saveAuthRoleUser(roleUserSaveDTO);
    }


    @ApiOperation("删除角色用户")
    @DeleteMapping("/user/delete")
    public boolean deleteAuthRoleUser(@Validated @RequestBody RoleUserDeleteDTO roleUserDeleteDTO) {
        return userRoleService.deleteAuthRoleUser(roleUserDeleteDTO);
    }

    @ApiOperation("查询角色用户")
    @GetMapping("/user/list")
    public RoleUserDTO getRoleUserList(@RequestParam("roleId") Long roleId) {
        return userRoleService.getRoleUserList(roleId);
    }

    @ApiOperation("查询角色资源")
    @GetMapping("/resource")
    public RoleResourceVO getRoleResource(@RequestParam("roleId") Long roleId) {
        return userRoleService.getRoleResource(roleId);
    }

}
