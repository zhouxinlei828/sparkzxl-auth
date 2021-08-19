package com.github.sparkzxl.auth.interfaces.controller.oauth;

import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.auth.application.service.IOauthService;
import com.github.sparkzxl.auth.infrastructure.oauth2.AccessTokenInfo;
import com.github.sparkzxl.constant.AppContextConstants;
import com.github.sparkzxl.core.context.AppContextHolder;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

/**
 * description: 授权管理
 *
 * @author zhouxinlei
 * @date 2021-08-19 12:31:52
 */
@Controller
@WebLog
@Api(tags = "授权管理")
@Slf4j
public class AuthorizeController {

    private AuthorizationEndpoint authorizationEndpoint;

    private IOauthService oauthService;

    @Autowired
    public void setOauthService(IOauthService oauthService) {
        this.oauthService = oauthService;
    }

    @Autowired
    public void setAuthorizationEndpoint(AuthorizationEndpoint authorizationEndpoint) {
        this.authorizationEndpoint = authorizationEndpoint;
    }

    @ApiOperation(value = "授权地址端点")
    @GetMapping("/oauth/getAuthorizeUrl")
    @ResponseResult
    @ResponseBody
    public String getAuthorizeUrl(@RequestParam(value = "clientId", required = false) String clientId,
                                  @RequestParam(value = "frontUrl", required = false) String frontUrl) {
        return oauthService.getAuthorizeUrl(clientId, frontUrl);
    }

    @ApiOperation(value = "授权端点")
    @GetMapping(value = "/oauth/authorize")
    public ModelAndView authorize(Map<String, Object> model, @RequestParam Map<String, String> parameters,
                                  SessionStatus sessionStatus, Principal principal) {
        String tenant = parameters.get(AppContextConstants.TENANT);
        AppContextHolder.setTenant(tenant);
        return authorizationEndpoint.authorize(model, parameters, sessionStatus, principal);
    }

    @ApiOperation(value = "授权成功回调端点")
    @GetMapping("/oauth/callBack")
    @ResponseResult
    @ResponseBody
    public AccessTokenInfo callBack(@RequestParam("code") String code,
                                    @RequestParam("state") String state) {
        return oauthService.authorizationCodeCallBack(code, state);
    }
}
