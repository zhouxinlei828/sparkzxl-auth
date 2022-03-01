package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessRoleService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessRole;
import com.github.sparkzxl.workflow.domain.model.dto.role.ProcessRoleQueryDTO;
import com.github.sparkzxl.workflow.domain.model.dto.role.ProcessRoleSaveDTO;
import com.github.sparkzxl.workflow.domain.model.dto.role.ProcessRoleUpdateDTO;
import com.github.sparkzxl.workflow.domain.model.dto.role.ProcessUserRoleSaveDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: 流程角色管理
 *
 * @author fin-9062
 * @date 2021-01-08 17:11:20
 */
@Response
@RestController
@RequestMapping("/process/role")
@HttpRequestLog
@Api(tags = "流程角色管理")
public class ExtProcessRoleController extends SuperCacheController<IExtProcessRoleService, Long, ExtProcessRole,
        ProcessRoleSaveDTO, ProcessRoleUpdateDTO, ProcessRoleQueryDTO, Object> {

    @ApiOperation("保存角色用户")
    @PostMapping("/user/save")
    public boolean saveRoleUser(@Validated @RequestBody ProcessUserRoleSaveDTO processUserRole) {
        return baseService.saveRoleUser(processUserRole);
    }

    @ApiOperation("查询角色用户Id列表")
    @GetMapping("/user/list")
    public List<Long> getRoleUserList(@RequestParam("roleId") Long roleId) {
        return baseService.getRoleUserList(roleId);
    }

}
