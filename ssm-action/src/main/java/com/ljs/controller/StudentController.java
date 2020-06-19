package com.ljs.controller;

import com.ljs.entity.Student;
import com.ljs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * create by ljs on 2020/6/19 22:04
 * <p>
 * description:
 */

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/getStudentList")
    @ResponseBody
    public List<Student> getStudentInfo(){
        return studentService.listStudent();
    }

    @RequestMapping("/list")
    public String listStudent(){
        return "listResult";
    }

    @RequestMapping("/register")
    public String registerPage(){
        return "register";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response, Student student) throws ServletException, IOException {

        studentService.insertStudent(student);
        request.getRequestDispatcher("/WEB-INF/view/listResult.jsp")
                .forward(request,response);

    }



}
