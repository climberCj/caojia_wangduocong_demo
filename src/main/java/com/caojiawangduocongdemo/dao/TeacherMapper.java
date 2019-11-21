package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public interface TeacherMapper {
    int deleteByPrimaryKey(String sysid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String sysid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    //通过教师账号查询
    Teacher findByTeacherId(String teacherId);
}