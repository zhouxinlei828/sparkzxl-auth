package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.endpoint.ErrorEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class ErrorController {

    @GetMapping("/error")
    public void error(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new ErrorEndpoint().showErrorPage(request, response);
    }

}
