package com.example.dynamic.controller;

import com.example.dynamic.entity.Student;
import com.example.dynamic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Breet
 * @Date: 2018/6/6 14:56
 * @Description:
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "getById/{id}")
    public void getById(@PathVariable("id") Integer id){
        Student s = studentService.selectByPrimaryKey(id);
        System.out.println(s.toString());
    }
    @RequestMapping(value = "save")
    public void save(){
        Student s = new Student();
        s.setAge(10);
        s.setName("学生："+System.currentTimeMillis());
        studentService.insertSelective(s);

        System.out.println(s.getId());
    }
}
