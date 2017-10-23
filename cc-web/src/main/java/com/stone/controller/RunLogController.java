package com.stone.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.stone.cc.beans.RunLog;
import com.stone.cc.service.IRunLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by shanglei on 2017/2/7.
 */
@Controller
@RequestMapping("/runlog")
public class RunLogController {

    @Autowired
    private IRunLogService IRunLogService;

    @RequestMapping("/listdemo")
    public ModelAndView tologin() throws Exception {
        ModelAndView mv = new ModelAndView("listdemo");
        mv.addObject("title", "机器列表页面");
        mv.addObject("viewPath", "listdemo");
        return mv;

    }

    @RequestMapping("/runlog")
    public ModelAndView login(HttpServletRequest req, RunLog runLog) throws Exception {
        String deployid = req.getParameter("deployid");
        List<RunLog> runLogLists = IRunLogService.selectRunlogById(deployid);
        System.out.println(runLogLists.toString());
        ModelAndView mv = new ModelAndView("showinfo");
        mv.addObject("runLogLists", runLogLists);
        return mv;
    }

}
