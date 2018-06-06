package com.example.dynamic.service.impl;

import com.example.dynamic.base.BaseServiceImpl;
import com.example.dynamic.dao.StudentMapper;
import com.example.dynamic.entity.Student;
import com.example.dynamic.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Author: Breet
 * @Date: 2018/6/6 14:47
 * @Description:
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, StudentMapper> implements StudentService {
}
