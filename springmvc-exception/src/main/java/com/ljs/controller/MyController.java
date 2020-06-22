package com.ljs.controller;

import com.ljs.exception.AgeException;
import com.ljs.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * create by ljs on 2020/6/22 7:00
 * <p>
 * description:
 */

@Controller
public class MyController {



    @RequestMapping("/exception")
    public String getException(){


        if ( true ){
            throw new NameException("这个是nameException");
        }

        return "result";
    }

    @RequestMapping("/ageException")
    public String getAgeException(){

        if ( true ){
            throw new AgeException("年龄太大了");
        }

        return "result";
    }


    /**
     * 定义局部异常处理方法。
     */
    @ExceptionHandler(NameException.class)
    public String handlerException(Exception e){


        System.out.println(e);

        return "nameError";

    }



}
