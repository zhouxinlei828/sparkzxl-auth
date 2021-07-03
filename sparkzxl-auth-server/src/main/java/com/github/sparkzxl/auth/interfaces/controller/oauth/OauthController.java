package com.github.sparkzxl.auth.interfaces.controller.oauth;

import com.github.sparkzxl.annotation.result.WebResult;
import com.github.sparkzxl.auth.application.service.IOauthService;
import com.github.sparkzxl.auth.infrastructure.oauth2.AccessTokenInfo;
import com.github.sparkzxl.log.annotation.WebLog;
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
 * description：授权登录管理
 *
 * @author charles.zhou
 * @date 2020/6/6 9:08 上午
 */
@Controller
@WebLog
@Api(tags = "授权管理")
@Slf4j
public class OauthController {

    private IOauthService oauthService;

    @Autowired
    public void setOauthService(IOauthService oauthService) {
        this.oauthService = oauthService;
    }


    @ApiOperation(value = "GET授权登录端口", notes = "GET授权登录端口")
    @GetMapping("/oauth/token")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "Authorization", value = "Basic Auth", paramType = "header", defaultValue = "Basic c3Bhcmt6eGw6MTIzNDU2")
    )
    @ResponseBody
    public OAuth2AccessToken getAccessToken(@RequestHeader(value = "Authorization") String authorization,
                                            @ApiIgnore Principal principal,
                                            @RequestParam Map<String, String> parameters)
            throws HttpRequestMethodNotSupportedException {
        log.info("Authorization = {}", authorization);
        return oauthService.getAccessToken(principal, parameters);
    }

    @ApiOperation(value = "POST授权登录端口", notes = "POST授权登录端口")
    @PostMapping("/oauth/token")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "Authorization", value = "Basic Auth", paramType = "header", defaultValue = "Basic c3Bhcmt6eGw6MTIzNDU2")
    )
    @ResponseBody
    public OAuth2AccessToken postAccessToken(@RequestHeader(value = "Authorization",required = false) String authorization,
                                             @ApiIgnore Principal principal,
                                             @RequestParam Map<String, String> parameters)
            throws HttpRequestMethodNotSupportedException {
        log.info("Authorization = {}", authorization);
        return oauthService.postAccessToken(principal, parameters);
    }

    @ApiOperation(value = "获取授权登录地址", notes = "获取授权登录地址")
    @GetMapping("/oauth/getAuthorizeUrl")
    @WebResult
    @ResponseBody
    public String getAuthorizeUrl(@RequestParam(value = "clientId", required = false) String clientId,
                                  @RequestParam(value = "frontUrl", required = false) String frontUrl) {
        return oauthService.getAuthorizeUrl(clientId, frontUrl);
    }

    @ApiOperation(value = "授权成功回调接口", notes = "授权成功回调接口")
    @GetMapping("/oauth/callBack")
    @WebResult
    @ResponseBody
    public AccessTokenInfo callBack(@RequestParam("code") String code,
                                    @RequestParam("state") String state) {
        return oauthService.authorizationCodeCallBack(code, state);
    }

}
