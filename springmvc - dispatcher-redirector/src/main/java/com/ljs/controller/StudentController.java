package com.ljs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by ljs on 2020/6/18 8:41
 * <p>
 * description:
 *
 *
 *  springmvc 中的控制层处理请求重定向的方法；简单写有以下三种。
 *
 *
 *  1）使用response.sendRedirect("完整视图名，")
 *
 *  2）ModelAndView
 *
 *  3）String 视图名。
 *
 *
 *
 *
 *
 *
 */

@Controller
public class StudentController {

    /**
     *  测试重定向;
     */

    @RequestMapping("/redirect.do")
    public void redirect(HttpServletResponse response) throws IOException {

        System.out.println("进行了请求重定向");
        response.sendRedirect("myjsp/myredirect.jsp?name=response");

    }

    /**
     *  重定向:
     *  使用  ModelAndView  + 重定向传递参数。
     *
     */

    @RequestMapping("redirect1.do")
    public ModelAndView redirect1(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "shemm");
        mv.addObject("age", "23");
        mv.setViewName("redirect:myjsp/myredirect.jsp");
        return mv;
    }

    @RequestMapping("redirect2.do")
    public String redirect2(){

        String name = "wowo";
        return "redirect:takeRedirec.do?&name=" + name;

    }

    @RequestMapping("/takeRedirec.do")
    public String redirector3(String name){

        System.out.println("redirector3: " + name);

        return "redirect:myjsp/myredirect.jsp";
    }


}
