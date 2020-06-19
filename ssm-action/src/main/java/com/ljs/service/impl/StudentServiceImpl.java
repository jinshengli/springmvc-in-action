package com.ljs.service.impl;

import com.ljs.dao.StudentDao;
import com.ljs.entity.Student;
import com.ljs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create by ljs on 2020/6/19 22:02
 * <p>
 * description:
 */

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public Integer insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    @Transactional
    public List<Student> listStudent() {
        return studentDao.listStudent();
    }
}
