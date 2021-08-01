package com.github.sparkzxl.workflow.interfaces.controller.online;


import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessRoleService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessRole;
import com.github.sparkzxl.workflow.interfaces.dto.role.ProcessRoleQueryDTO;
import com.github.sparkzxl.workflow.interfaces.dto.role.ProcessRoleSaveDTO;
import com.github.sparkzxl.workflow.interfaces.dto.role.ProcessRoleUpdateDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 表单设计模板 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@RestController
@RequestMapping("/onl-form-template")
public class OnlFormTemplateController extends SuperCacheController<IExtProcessRoleService, Long, ExtProcessRole,
        ProcessRoleSaveDTO, ProcessRoleUpdateDTO, ProcessRoleQueryDTO, Object> {

}
