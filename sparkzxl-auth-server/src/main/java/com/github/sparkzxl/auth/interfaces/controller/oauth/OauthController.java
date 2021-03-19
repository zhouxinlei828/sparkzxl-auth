package com.github.sparkzxl.auth.interfaces.controller.oauth;

import com.github.sparkzxl.auth.application.service.IOauthService;
import com.github.sparkzxl.auth.application.service.IRealmPoolService;
import com.github.sparkzxl.auth.infrastructure.oauth2.AccessTokenInfo;
import com.github.sparkzxl.auth.infrastructure.oauth2.AuthorizationRequest;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.core.entity.CaptchaInfo;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


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
    private IRealmPoolService tenantInfoService;

    @Autowired
    public void setOauthService(IOauthService oauthService) {
        this.oauthService = oauthService;
    }

    @Autowired
    public void setTenantInfoService(IRealmPoolService tenantInfoService) {
        this.tenantInfoService = tenantInfoService;
    }

    @ApiOperation(value = "登录页面", notes = "登录页面")
    @RequestMapping(value = "/authentication/require", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowCredentials = "true")
    public String require(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return "login";
    }

    @ApiOperation(value = "获取授权登录地址", notes = "获取授权登录地址")
    @GetMapping("/oauth/getAuthorizeUrl")
    @ResponseResult
    @ResponseBody
    public String getAuthorizeUrl(@RequestParam(value = "clientId", required = false) String clientId,
                                  @RequestParam(value = "frontUrl", required = false) String frontUrl) {
        return oauthService.getAuthorizeUrl(clientId, frontUrl);
    }

    @ApiOperation(value = "GET授权登录端口", notes = "GET授权登录端口")
    @GetMapping("/sso/token")
    @ResponseResult
    @ResponseBody
    public AccessTokenInfo getAccessToken(AuthorizationRequest authorizationRequest){
        return oauthService.getAccessToken(authorizationRequest);
    }

    @ApiOperation(value = "POST授权登录端口", notes = "POST授权登录端口")
    @PostMapping("/sso/token")
    @ResponseResult
    @ResponseBody
    public AccessTokenInfo postAccessToken(@RequestBody AuthorizationRequest authorizationRequest){
        return oauthService.postAccessToken(authorizationRequest);
    }

    @ApiOperation(value = "验证码", notes = "验证码")
    @GetMapping(value = "/oauth/captcha")
    @ResponseResult
    @ResponseBody
    public CaptchaInfo captcha(@RequestParam(value = "type") String type) {
        return oauthService.createCaptcha(type);
    }

    @ApiOperation(value = "验证验证码", notes = "验证验证码")
    @GetMapping(value = "/oauth/checkCaptcha")
    @ResponseResult
    @ResponseBody
    public boolean checkCaptcha(@RequestParam(value = "key") String key, @RequestParam(value = "code") String code) {
        return oauthService.checkCaptcha(key, code);
    }

    @ApiOperation(value = "校验领域池信息", notes = "校验领域池信息")
    @GetMapping(value = "/oauth/checkTenant")
    @ResponseResult
    @ResponseBody
    public boolean checkTenantCode(@RequestParam(value = "tenantCode") String tenantCode) {
        return tenantInfoService.checkTenantCode(tenantCode);
    }

    @ApiOperation(value = "授权成功回调接口", notes = "授权成功回调接口")
    @GetMapping("/oauth/callBack")
    @ResponseResult
    @ResponseBody
    public AccessTokenInfo callBack(@RequestParam("code") String code,
                                    @RequestParam("state") String state) {
        return oauthService.authorizationCodeCallBack(code, state);
    }

}
