package com.github.sparkzxl.auth.interfaces.controller.mock;

import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-07-12 15:08
 */
@RestController
@ResponseResult
@HttpRequestLog
@Api(tags = "Mock管理")
@RequestMapping("/mock")
@RequiredArgsConstructor
public class MockController {

    private final IUserService userService;

    @ApiOperation("生成用户测试数据")
    @GetMapping("/mockData")
    public boolean mockUserData() {
        return userService.mockUserData();
    }

    @ApiOperation("测试表单数据")
    @PostMapping("/testFormData")
    public AuthRole mockUserData(AuthRole authRole) {
        return authRole;
    }


}
