package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 流程角色用户管理
 *
 * @author fin-9062
 * @date   2021-01-08 17:14:23
 */
@Api(tags = "流程角色用户管理")
@WebLog
@ResponseResult
@RestController
@RequestMapping("/process/user/role")
public class ExtProcessUserRoleController {

}
