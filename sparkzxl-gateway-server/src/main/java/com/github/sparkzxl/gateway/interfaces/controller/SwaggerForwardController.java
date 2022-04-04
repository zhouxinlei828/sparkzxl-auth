package com.github.sparkzxl.gateway.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;


/**
 * description: swagger 转发
 *
 * @author charles.zhou
 * @date 2020-05-24 12:18:02
 */
@Controller
public class SwaggerForwardController {

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("/gate/doc.html")
    public Rendering doc() {
        String uri = String.format("%s/doc.html", serverProperties.getServlet().getContextPath());
        return Rendering.redirectTo(uri).build();
    }
}
