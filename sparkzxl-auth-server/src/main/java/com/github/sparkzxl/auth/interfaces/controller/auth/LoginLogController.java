package com.github.sparkzxl.auth.interfaces.controller.auth;

import com.github.sparkzxl.auth.application.service.ILoginLogService;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * description：登录日志
 *
 * @author charles.zhou
 * @date 2020/6/17 0017
 */
@RestController
@ResponseResult
@WebLog
@Api(value = "LoginLog", tags = "登录日志")
public class LoginLogController {

    private final ILoginLogService loginLogService;

    public LoginLogController(ILoginLogService loginLogService) {
        this.loginLogService = loginLogService;
    }


    @ApiOperation("清空日志")
    @DeleteMapping("/clear")
    public Boolean clear(@RequestParam(required = false, defaultValue = "1") Integer type) {
        LocalDateTime clearBeforeTime = null;
        Integer clearBeforeNum = null;
        switch (type) {
            case 1:
                clearBeforeTime = LocalDateTime.now().plusMonths(-1);
                break;
            case 2:
                clearBeforeTime = LocalDateTime.now().plusMonths(-3);
                break;
            case 3:
                clearBeforeTime = LocalDateTime.now().plusMonths(-6);
                break;
            case 4:
                clearBeforeTime = LocalDateTime.now().plusMonths(-12);
                break;
            case 5:
                clearBeforeNum = 1000;
                break;
            case 6:
                // 清理一万条以前日志数据
                clearBeforeNum = 10000;
                break;
            case 7:
                // 清理三万条以前日志数据
                clearBeforeNum = 30000;
                break;
            case 8:
                // 清理十万条以前日志数据
                clearBeforeNum = 100000;
                break;
            default:
                return false;
        }
        return loginLogService.clearLog(clearBeforeTime, clearBeforeNum);
    }
}
