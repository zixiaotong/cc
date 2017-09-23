package com.stone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shanglei
 * @date 2017/8/7.
 */
@Controller
public class OnlineOrderController {

    /**
     * 上线顺序跳转方法
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/toonlineorder")
    public ModelAndView toOnlineOrder() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/pages/onlineorder");
        return mv;
    }

    /**
     * 启动顺序跳转方法
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/tostartorder")
    public ModelAndView toStartOrder() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/pages/startorder");
        return mv;
    }
}
