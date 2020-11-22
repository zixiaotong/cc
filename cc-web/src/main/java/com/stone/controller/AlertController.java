package com.stone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shanglei
 * @date 2018/5/14 17:16
 */
@Controller
@RequestMapping("alert")
public class AlertController {
    @RequestMapping("heart")
    public ModelAndView list() {
        return new ModelAndView("common/heart");
    }
}
