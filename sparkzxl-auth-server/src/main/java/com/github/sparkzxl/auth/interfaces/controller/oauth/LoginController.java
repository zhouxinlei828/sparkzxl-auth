package com.github.sparkzxl.auth.interfaces.controller.oauth;

import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.auth.application.service.IOauthService;
import com.github.sparkzxl.auth.infrastructure.oauth2.AccessTokenInfo;
import com.github.sparkzxl.auth.infrastructure.oauth2.AuthorizationRequest;
import com.github.sparkzxl.auth.infrastructure.properties.SystemProperties;
import com.github.sparkzxl.core.utils.RequestContextHolderUtils;
import com.github.sparkzxl.entity.core.CaptchaInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * description: 登录管理
 *
 * @author charles.zhou
 * @date 2021-03-13 18:58:25
 */
@Controller
@Api(tags = "登录管理")
@RequiredArgsConstructor
public class LoginController {

    private final IOauthService oauthService;
    private final SystemProperties systemProperties;

    @ApiOperation(value = "登录页面", notes = "登录页面")
    @RequestMapping(value = "/authentication/require", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowCredentials = "true")
    public String require() {
        RequestContextHolderUtils.getRequest().setAttribute("systemName", systemProperties.getName());
        return "login";
    }

    @ApiOperation(value = "GET授权登录端口", notes = "GET授权登录端口")
    @GetMapping("/authentication/token")
    @ResponseResult
    @ResponseBody
    public AccessTokenInfo getAccessToken(AuthorizationRequest authorizationRequest) {
        return oauthService.getAccessToken(authorizationRequest);
    }

    @ApiOperation(value = "POST授权登录端口", notes = "POST授权登录端口")
    @PostMapping("/authentication/token")
    @ResponseResult
    @ResponseBody
    public AccessTokenInfo postAccessToken(@RequestBody AuthorizationRequest authorizationRequest) {
        return oauthService.postAccessToken(authorizationRequest);
    }

    @ApiOperation(value = "验证码", notes = "验证码")
    @GetMapping(value = "/authentication/captcha")
    @ResponseResult
    @ResponseBody
    public CaptchaInfo captcha(@RequestParam(value = "type") String type) {
        return oauthService.createCaptcha(type);
    }

    @ApiOperation(value = "验证验证码", notes = "验证验证码")
    @GetMapping(value = "/authentication/checkCaptcha")
    @ResponseResult
    @ResponseBody
    public boolean checkCaptcha(@RequestParam(value = "key") String key, @RequestParam(value = "code") String code) {
        return oauthService.checkCaptcha(key, code);
    }
}
