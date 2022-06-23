package com.github.sparkzxl.oauth.interfaces.controller;

import com.github.sparkzxl.web.annotation.Response;
import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.oauth.application.service.IOauthService;
import com.github.sparkzxl.oauth.infrastructure.oauth2.AccessTokenInfo;
import com.github.sparkzxl.oauth.infrastructure.oauth2.AuthorizationRequest;
import com.github.sparkzxl.oauth.infrastructure.properties.SystemProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 登录管理
 *
 * @author charles.zhou
 * @since 2021-03-13 18:58:25
 */
@Controller
@Api(tags = "登录管理")
@RequiredArgsConstructor
public class LoginController {

    private final IOauthService oauthService;
    private final SystemProperties systemProperties;

    @ApiOperation(value = "登录页面", notes = "登录页面")
    @RequestMapping(value = "/authentication/require", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
    public ModelAndView require(HttpServletRequest request, HttpServletResponse response) {
        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
        ModelAndView model = new ModelAndView("login");
        String[] parameterValues = savedRequest.getParameterValues(BaseContextConstants.TENANT_ID);
        if (ArrayUtils.isNotEmpty(parameterValues)) {
            model.addObject(BaseContextConstants.TENANT_ID, parameterValues[0]);
        }
        model.addObject("systemName", systemProperties.getName());
        return model;
    }

    @ApiOperation(value = "GET授权登录端口", notes = "GET授权登录端口")
    @GetMapping("/authentication/token")
    @Response
    @ResponseBody
    public AccessTokenInfo getAccessToken(AuthorizationRequest authorizationRequest) {
        return oauthService.getAccessToken(authorizationRequest);
    }

    @ApiOperation(value = "POST授权登录端口", notes = "POST授权登录端口")
    @PostMapping("/authentication/token")
    @Response
    @ResponseBody
    public AccessTokenInfo postAccessToken(@RequestBody AuthorizationRequest authorizationRequest) {
        return oauthService.postAccessToken(authorizationRequest);
    }
}
