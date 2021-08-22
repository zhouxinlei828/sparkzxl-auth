package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.JapIds;
import com.fujieid.jap.ids.endpoint.LoginEndpoint;
import com.fujieid.jap.ids.model.IdsResponse;
import com.fujieid.jap.ids.util.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-14 11:49
 * @since 1.0.0
 */
@RequestMapping("/oauth")
@Controller
public class LoginController {

    @GetMapping("/login")
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new LoginEndpoint().showLoginPage(request, response);
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, HttpServletResponse response) {
        IdsResponse<String, String> idsResponse = new LoginEndpoint().signin(request, response);
        return new RedirectView(idsResponse.getData());
    }

    /**
     * 演示自定义登录页面的实现方式， 自定义授权页面，需要通过 <code>JapIds.registerContext(new IdsContext().setIdsConfig(new IdsConfig().setLoginPageUrl(host + "/oauth/login/customize")</code> 配置登录页面的入口
     *
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @GetMapping("/login/customize")
    public ModelAndView loginCustomize(HttpServletRequest request, Model model) throws IOException {
        String authenticationUrl = ObjectUtils.appendIfNotEndWith(JapIds.getIdsConfig().getLoginUrl(), "?") + request.getQueryString();
        model.addAttribute("requestPath", authenticationUrl);
        model.addAttribute("usernameField", JapIds.getIdsConfig().getUsernameField());
        model.addAttribute("passwordField", JapIds.getIdsConfig().getPasswordField());
        return new ModelAndView("login");
    }

}
