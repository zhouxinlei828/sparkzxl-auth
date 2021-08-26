package com.github.sparkzxl.oauth.interfaces.controller;

import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.oauth.application.service.IOauthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.Map;


/**
 * description：token令牌管理
 *
 * @author charles.zhou
 * @date 2020/6/6 9:08 上午
 */
@Controller
@WebLog
@Api(tags = "Token令牌管理")
@Slf4j
public class TokenController {

    private IOauthService oauthService;

    @Autowired
    public void setOauthService(IOauthService oauthService) {
        this.oauthService = oauthService;
    }

    @ApiOperation(value = "Token令牌获取")
    @PostMapping("/oauth/token")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "Authorization", value = "Basic Auth", paramType = "header", defaultValue = "Basic c3Bhcmt6eGw6MTIzNDU2")
    )
    @ResponseBody
    public OAuth2AccessToken postAccessToken(@RequestHeader(value = "Authorization", required = false) String authorization,
                                             @ApiIgnore Principal principal,
                                             @RequestParam Map<String, String> parameters)
            throws HttpRequestMethodNotSupportedException {
        log.info("Authorization = {}", authorization);
        return oauthService.postAccessToken(principal, parameters);
    }


    @ApiOperation("获取用户基本信息")
    @GetMapping("/user/userinfo")
    @ResponseBody
    @ResponseResult
    public AuthUserBasicVO getAuthUserBasicInfo(@ApiIgnore AuthUserInfo<Long> authUserInfo) {
        return oauthService.userinfo(authUserInfo);
    }

}
