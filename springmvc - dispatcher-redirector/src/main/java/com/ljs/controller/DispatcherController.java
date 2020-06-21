package com.ljs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by ljs on 2020/6/21 20:55
 * <p>
 * description:
 *
 * 请求转发：
 *
 *      服务器内部做请求转发，同用一个请求对另外一个真实资源的访问。
 *
 *      可以转发之后的处理器方法或者视图，可以使用request域中模型数据。
 *
 */

@Controller
public class DispatcherController {


    /**
     *  使用request的 请求转发方法。
     */
    @RequestMapping("/doDispact")
    public void doDispactcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("name", "神马");
        request.getRequestDispatcher("/WEB-INF/jsp/some.jsp?age=23").forward(request, response);

    }


    /**
     *  使用forward 关键字。
     * @param request
     * @return
     */

    @RequestMapping("/doDispact1.do")
    public String doDispatcher1(HttpServletRequest request) {

        request.setAttribute("name", "dispatcher1");

        return "forward:/WEB-INF/jsp/some.jsp?age=23";

    }

    /**
     *  modeAndView + forward.
     * @param request
     * @return
     */
    @RequestMapping("/doDispact2.do")
    public ModelAndView doDispatcher2(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "modelAndView");
        mv.setViewName("forward:/WEB-INF/jsp/some.jsp?age=21");
        return mv;

    }








}
