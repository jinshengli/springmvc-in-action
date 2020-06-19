package com.ljs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by ljs on 2020/6/18 19:29
 * <p>
 * description:
 */
@Controller
@RequestMapping("/test")
public class MyController {


    @RequestMapping("/some.do")
    public ModelAndView doSome(HttpServletRequest request,
                               HttpServletResponse response) {

        return new ModelAndView("some");
    }


    @RequestMapping("/doOther.do")
    public ModelAndView doOther(HttpServletRequest request,
                               HttpServletResponse response) {

        return new ModelAndView("other");
    }

}
