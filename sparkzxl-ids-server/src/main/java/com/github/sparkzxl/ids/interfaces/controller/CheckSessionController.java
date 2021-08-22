package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.JapIds;
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
public class CheckSessionController {

    @GetMapping("/check_session")
    public IdsResponse<String, Object> token(HttpServletRequest request) {
        return new IdsResponse<String, Object>().data(JapIds.isAuthenticated(request));
    }
}
