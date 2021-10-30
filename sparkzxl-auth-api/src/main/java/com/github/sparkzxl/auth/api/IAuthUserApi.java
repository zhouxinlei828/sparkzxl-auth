package com.github.sparkzxl.auth.api;

import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.auth.api.dto.UserDetailInfo;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description: 用户API
 *
 * @author zhouxinlei
 * @date 2021-07-03 10:39:53
 */
public interface IAuthUserApi {

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return AuthUserDetail<Long>
     */
    @GetMapping("/getUserDetailInfo")
    UserDetailInfo getUserDetailInfo(@RequestParam("username") String username);

    /**
     * 获取全局用户信息
     *
     * @param username 用户名
     * @return AuthUserInfo<Long>
     */
    @GetMapping("/getAuthUserInfo")
    AuthUserInfo<Long> getAuthUserInfo(@RequestParam("username") String username);

    /**
     * 获取用户基本信息
     *
     * @param userId 用户id
     * @return AuthUserBasicVO
     */
    @ApiOperation("获取用户基本信息")
    @GetMapping("/userinfo")
    AuthUserBasicVO getUserByUserId(@RequestParam("userId") Long userId);

    /**
     * 获取用户基本信息
     *
     * @param username 用户名
     * @return AuthUserBasicVO
     */
    @ApiOperation("获取用户基本信息")
    @GetMapping("/getUserByUsername")
    AuthUserBasicVO getUserByUsername(@RequestParam("username") String username);
}
