package com.stone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shanglei
 * @date 2017/8/7.
 */
@Controller
public class XshellManageController {

    @RequestMapping("/toxshellmanage")
    public ModelAndView toXshellManage() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/pages/xshellmanage");
        return mv;
    }
}
