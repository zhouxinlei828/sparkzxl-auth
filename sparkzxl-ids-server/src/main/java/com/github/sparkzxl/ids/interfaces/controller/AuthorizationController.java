package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.endpoint.AuthorizationEndpoint;
import com.fujieid.jap.ids.model.IdsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-14 11:49
 * @since 1.0.0
 */
@RequestMapping("/oauth")
@Controller
public class AuthorizationController {

    @GetMapping("/authorize")
    public RedirectView authorize(HttpServletRequest request) throws IOException {
        IdsResponse<String, String> idsResponse = new AuthorizationEndpoint().authorize(request);
        return new RedirectView(idsResponse.getData());
    }

    @PostMapping("/authorize")
    public RedirectView doAuthorize(HttpServletRequest request) {
        IdsResponse<String, String> idsResponse = new AuthorizationEndpoint().agree(request);
        return new RedirectView(idsResponse.getData());
    }

    /**
     * 自动授权，跳过确认授权页面
     *
     * @param request
     * @return
     */
    @GetMapping("/authorize/auto")
    public RedirectView doAuthorizeAutoApprove(HttpServletRequest request) {
        return this.doAuthorize(request);
    }
}
