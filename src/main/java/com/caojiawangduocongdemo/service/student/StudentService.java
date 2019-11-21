package com.caojiawangduocongdemo.service.student;

import com.caojiawangduocongdemo.entity.Student;
import com.github.pagehelper.Page;

/**
 * @author caojia
 * @time 下午 9:40
 */
public interface StudentService {
    //学生登录验证
    public boolean allowLogin(String studentId,String password);
    //根据学生用户名查询
    Student findByStudentId(String studentId);
}
