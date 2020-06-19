package com.ljs.controller;

import com.ljs.vo.StudentVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * create by ljs on 2020/6/18 8:41
 * <p>
 * description:  接收请求参数。
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

    @RequestMapping("/register.do")
    public ModelAndView register(HttpServletRequest request, String name, Integer age){

        ModelAndView modelAndView = new ModelAndView();

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.setViewName("result");

        return modelAndView;
    }

    /**
     *   这是@RequestMapping 同时存在post方法。中文字符编码问题。
     * @param request
     * @param name
     * @param age
     * @return
     */

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, String name, Integer age){

        ModelAndView modelAndView = new ModelAndView();

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.setViewName("result");

        return modelAndView;
    }

    /**
     * 使用 @RequestParam之后； 默认是请求参数必须有。
     * @param request
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/param.do", method = RequestMethod.POST)
    public ModelAndView doParameter(HttpServletRequest request, @RequestParam("rname") String name, @RequestParam("rage") Integer age){

        ModelAndView modelAndView = new ModelAndView();

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.setViewName("result");

        return modelAndView;

    }



    @RequestMapping(value = "/getParamByObject", method = RequestMethod.POST)
    public ModelAndView getParambyObject(HttpServletRequest request, StudentVo studentVo){

        ModelAndView modelAndView = new ModelAndView();

        System.out.println("name = " + studentVo.getName());
        System.out.println("age = " + studentVo.getAge());

        modelAndView.addObject("name", studentVo.getName());
        modelAndView.addObject("age", studentVo.getAge());
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.setViewName("result");

        return modelAndView;
    }




}
