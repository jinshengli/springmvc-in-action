package com.ljs.handle;

import com.ljs.exception.AgeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * create by ljs on 2020/6/22 10:46
 * <p>
 * description:
 * 全局异常处理类
 */

@ControllerAdvice
public class GloabalExceptionHanlder {



    @ExceptionHandler(AgeException.class)
    public String ageExceptionHandler(Exception e){

        System.out.println(this.getClass());
        System.out.println(e);

        return "ageError";
    }




}
