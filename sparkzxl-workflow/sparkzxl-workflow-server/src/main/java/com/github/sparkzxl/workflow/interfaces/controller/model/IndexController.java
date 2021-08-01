package com.github.sparkzxl.workflow.interfaces.controller.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description:
 *
 * @author charles.zhou
 * @date 2020-10-02 10:35:45
 */
@AllArgsConstructor
@Api(tags = "页面管理")
@Controller
public class IndexController {

    @ApiOperation("流程图设计页")
    @GetMapping("editor")
    public String editor() {
        return "index";
    }
}
