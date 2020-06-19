package com.ljs.controller;

import com.ljs.vo.StudentVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * create by ljs on 2020/6/19 8:08
 * <p>
 * description:
 *          返回自定义对象【object，list，map】，该对象会由springnmvc框架自动装换成 json字符串输出。
 *
 *          使用注解 @ResponseBody
 */


@Controller
@RequestMapping("/json")
public class ReturnJsonController {


    /**
     *  1. 返回自定义对象
     *
     *   No converter found for return value of type: class com.ljs.vo.StudentVo]
     *
     *  需要由<mvc:annotation-driven/>来完成
     *
     *  开启注解驱动。
     */

    @RequestMapping("/student.do")
    @ResponseBody
    public StudentVo getStudentVo(){

        StudentVo studentVo = new StudentVo();
        studentVo.setName("2020/6/19");
        studentVo.setAge(23);
        return studentVo;
    }

    /**
     *  2. 返回List集合
     */
    @RequestMapping("/listStudent.do")
    @ResponseBody
    public List<StudentVo> getListStudentVo(){

        List<StudentVo> list = new ArrayList<>();

        for ( int i = 0; i < 4; ++i ){
            StudentVo studentVo = new StudentVo();
            studentVo.setName("stu" + i);
            studentVo.setAge(i+20);
            list.add(studentVo);
        }

        return list;
    }

    /**
     * 3. 返回String 字符； 还有是含有中文的字符串。需要@RequestMaping
     *
     *  的一个属性指明一个字符集； produces 设置输出结果类型;
     */

    @RequestMapping(
            value = "/string", produces = "text/application;charset=utf8")
    @ResponseBody
    public String getString(){


        return "我是个Tina才";

    }





}
