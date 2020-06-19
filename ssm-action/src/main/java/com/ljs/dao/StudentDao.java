package com.ljs.dao;

import com.ljs.entity.Student;

import java.util.List;

/**
 * create by ljs on 2020/6/19 22:00
 * <p>
 * description:
 */
public interface StudentDao {

    Integer insertStudent(Student student);


    List<Student> listStudent();


}
