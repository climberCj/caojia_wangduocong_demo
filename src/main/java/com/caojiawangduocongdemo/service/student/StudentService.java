package com.caojiawangduocongdemo.service.student;

import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.utils.PageInfo;

/**
 * @author DC
 * @time 16：00
 */
public interface StudentService {
    //学生登录验证
    public boolean allowLogin(String studentId,String password);
    //根据学生用户名查询
    Student findByStudentId(String studentId);
    //根据班级查询
    Student findBysclass(String sclass);
    //根据姓名查询
    Student findByName(String studentName);
    //学生分页
    PageInfo<Student> sPage(int page, int pageSize, String q,String status);
    //添加学生
    void insert(Student student);
    //根据sysId修改
    void updateBySysid(String sysid,String scalss,String stupic,int result);
    //根据sysId删除
    void delete(String sysid);
    //逻辑性删除
    void updateStatus(String sysid,String status);



}
