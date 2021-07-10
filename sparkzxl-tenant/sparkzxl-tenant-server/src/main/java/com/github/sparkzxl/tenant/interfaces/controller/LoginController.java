package com.github.sparkzxl.tenant.interfaces.controller;

import com.github.sparkzxl.annotation.result.WebResult;
import com.github.sparkzxl.core.support.BizExceptionAssert;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.entity.security.AuthRequest;
import com.github.sparkzxl.entity.security.AuthToken;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.tenant.domain.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.security.auth.login.AccountNotFoundException;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-07-03 14:21:16
 */
@RestController
@WebResult
@WebLog
@Api(value = "loginController", tags = "登录管理")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public AuthToken login(@RequestBody AuthRequest authRequest) {
        try {
            return loginService.login(authRequest);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            BizExceptionAssert.businessFail("账户不能为空");
        } catch (PasswordException e) {
            e.printStackTrace();
            BizExceptionAssert.businessFail("密码错误");
        }
        return null;
    }

    @ApiOperation("获取用户基本信息")
    @GetMapping("/userinfo")
    public AuthUserInfo<Long> getAuthUserBasicInfo(@ApiIgnore AuthUserInfo<Long> authUserInfo) {
        return authUserInfo;
    }
}
