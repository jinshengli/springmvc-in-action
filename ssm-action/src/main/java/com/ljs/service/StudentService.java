package com.ljs.service;

import com.ljs.entity.Student;

import java.util.List;

/**
 * create by ljs on 2020/6/19 22:01
 * <p>
 * description:
 */
public interface StudentService {

    Integer insertStudent(Student student);

    List<Student> listStudent();

}
