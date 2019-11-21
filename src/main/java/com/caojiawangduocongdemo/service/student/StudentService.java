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

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示条数
     * @return
     */
    Page<Student> findByPage(int pageNo,int pageSize);
}
