package com.ljs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * create by ljs on 2020/6/18 8:41
 * <p>
 * description:
 */

@Controller
@RequestMapping(value = "/stu")
public class StudentController {


    @RequestMapping("/list.do")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("res", "index");
        modelAndView.setViewName("result");
        return modelAndView;

    }


}
