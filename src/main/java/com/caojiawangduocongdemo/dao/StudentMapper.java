package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Student;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {
    int deleteByPrimaryKey(String sysid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sysid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    //通过学生账号查询
    Student findByStudentId(String studentId);

}