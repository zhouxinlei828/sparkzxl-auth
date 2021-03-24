package com.github.sparkzxl.job.admin.controller;

import com.github.sparkzxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * description: 首页管理
 *
 * @author charles.zhou
 * @date   2021-03-12 15:25:56
 */
@Controller
public class IndexController {

    @Resource
    private XxlJobService xxlJobService;

    @RequestMapping("/")
    public String index(Model model) {
        Map<String, Object> dashboardMap = xxlJobService.dashboardInfo();
        model.addAllAttributes(dashboardMap);
        return "index";
    }

    @RequestMapping("/chartInfo")
    @ResponseBody
    public ReturnT<Map<String, Object>> chartInfo(Date startDate, Date endDate) {
        return xxlJobService.chartInfo(startDate, endDate);
    }

    @RequestMapping("/help")
    public String help() {
        return "help";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
