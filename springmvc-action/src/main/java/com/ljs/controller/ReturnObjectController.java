package com.ljs.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljs.vo.StudentVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * create by ljs on 2020/6/18 21:42
 * <p>
 * description:  处理器方法返回值；有我们自己处理和决定。
 */

@Controller
@RequestMapping(value = "/obj")
public class ReturnObjectController {


    /**
     *  1. 普通返回ModelAndView
     */


    /**
     *  2. 返回逻辑视图;
     */
    @RequestMapping(value = "/list.do", method = RequestMethod.GET)
    public String getObject(){

        return "list";  // 框架做了forward请求。
    }

    /**
     *  3. 无返回值。void; 使用response返回。
     */

    @RequestMapping(value = "/void.do")
    public void getVoid(HttpServletResponse response) throws IOException {

        response.setContentType("application/json;charset=utf8");
        PrintWriter writer = response.getWriter();
        writer.write("这是一个response");
        writer.flush();

    }


    /**
     *  4. 无返回值。 void, 通过HttpServletResponse返回json对象字符串数据。
     *
     *  需要手动转换成对象 --》 json字符串。
     */

    @RequestMapping(value = "/objJson.do", method = RequestMethod.POST)
    public void respJsonObjectString(HttpServletResponse response, StudentVo studentVo ) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(studentVo);

        System.out.println("json as ： " + string);

        PrintWriter writer = response.getWriter();
        writer.print(string);
        writer.flush();
        writer.close();

    }







}
