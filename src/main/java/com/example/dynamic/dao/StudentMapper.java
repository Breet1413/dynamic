package com.example.dynamic.dao;

import com.example.dynamic.base.BaseDao;
import com.example.dynamic.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper  extends BaseDao<Student> {

}