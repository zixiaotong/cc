package com.stone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shanglei
 * @date 2017/8/2.
 */
@Controller
public class ProjectManageController {

    @RequestMapping("/index")
    public ModelAndView index() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/pages/index");
        return mv;
    }

    @RequestMapping("/toprojectmanage")
    public ModelAndView toProjectManage() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/pages/projectmanage");
        return mv;
    }
}
