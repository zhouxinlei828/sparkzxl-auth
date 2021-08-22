package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.endpoint.LogoutEndpoint;
import com.fujieid.jap.ids.model.IdsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-14 11:49
 * @since 1.0.0
 */
@RequestMapping("/oauth")
@RestController
public class LogoutController {

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response) {
        IdsResponse<String, String> idsResponse = new LogoutEndpoint().logout(request, response);
        return new RedirectView(idsResponse.getData());
    }
}
