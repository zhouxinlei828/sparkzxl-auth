package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.endpoint.UserInfoEndpoint;
import com.fujieid.jap.ids.model.IdsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-14 11:49
 * @since 1.0.0
 */
@RequestMapping("/oauth")
@RestController
public class UserInfoController {

    @GetMapping("/userinfo")
    public IdsResponse<String, Object> userinfo(HttpServletRequest request) {
        return new UserInfoEndpoint().getCurrentUserInfo(request);
    }
}
