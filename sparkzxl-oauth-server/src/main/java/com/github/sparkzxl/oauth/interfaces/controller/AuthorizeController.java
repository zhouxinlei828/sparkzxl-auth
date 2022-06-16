package com.github.sparkzxl.oauth.interfaces.controller;

import com.github.sparkzxl.web.annotation.Response;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.oauth.application.service.IOauthService;
import com.github.sparkzxl.oauth.infrastructure.oauth2.AccessTokenInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description: 授权管理
 *
 * @author zhouxinlei
 * @since 2021-08-19 12:31:52
 */
@Controller
@HttpRequestLog
@Api(tags = "授权管理")
@Slf4j
public class AuthorizeController {

    private IOauthService oauthService;

    @Autowired
    public void setOauthService(IOauthService oauthService) {
        this.oauthService = oauthService;
    }

    @ApiOperation(value = "授权地址端点")
    @GetMapping("/oauth/getAuthorizeUrl")
    @Response
    @ResponseBody
    public String getAuthorizeUrl(@RequestParam(value = "clientId", required = false) String clientId,
                                  @RequestParam(value = "frontUrl", required = false) String frontUrl) {
        return oauthService.getAuthorizeUrl(clientId, frontUrl);
    }

    @ApiOperation(value = "授权成功回调端点")
    @GetMapping("/oauth/callBack")
    @Response
    @ResponseBody
    public AccessTokenInfo callBack(@RequestParam("code") String code,
                                    @RequestParam("state") String state) {
        return oauthService.authorizationCodeCallBack(code, state);
    }
}
