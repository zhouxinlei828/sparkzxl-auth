package com.github.sparkzxl.workflow.interfaces.controller.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.activiti.engine.RepositoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * description:
 *
 * @author charles.zhou
 * @date   2020-10-02 10:35:45
 */
@AllArgsConstructor
@Api(tags = "页面管理")
@Controller
public class IndexController {

    private final RepositoryService repositoryService;

    @ApiOperation("首页")
    @GetMapping("index")
    public String index(ModelAndView modelAndView) {
        modelAndView.addObject("modelList", repositoryService.createModelQuery().list());
        return "index";
    }

    @ApiOperation("模型列表页")
    @GetMapping("modelList")
    public String modelList(ModelAndView modelAndView) {
        modelAndView.setViewName("modelList");
        return "modelList";
    }

    @ApiOperation("流程图设计页")
    @GetMapping("editor")
    public String editor() {
        return "modeler";
    }
}
