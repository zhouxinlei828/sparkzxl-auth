package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessUserService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.interfaces.dto.user.ProcessUserQueryDTO;
import com.github.sparkzxl.workflow.interfaces.dto.user.ProcessUserSaveDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 流程用户管理
 *
 * @author charles.zhou
 * @date 2021-01-08 17:12:52
 */
@Api(tags = "流程用户管理")
@WebLog
@ResponseResult
@RestController
@RequestMapping("/process/user")
public class ExtProcessUserController extends SuperCacheController<IExtProcessUserService, Long, ExtProcessUser,
        ProcessUserSaveDTO, ProcessUserQueryDTO, ProcessUserQueryDTO, Object> {

}
