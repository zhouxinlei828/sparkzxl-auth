package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.service.IdsClientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-14 16:37
 * @since 1.0.0
 */
@Controller
public class HomeController {
    @Autowired
    private IdsClientDetailService idsClientDetailService;

    @RequestMapping("/")
    public ModelAndView index(Model model) {
        model.addAttribute("clientDetails", idsClientDetailService.getAllClientDetail());
        return new ModelAndView("index");
    }
}
