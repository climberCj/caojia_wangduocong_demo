package com.caojiawangduocongdemo.service.student;

/**
 * @author caojia
 * @time 下午 9:40
 */
public interface StudentService {
    //学生登录验证
    public boolean allowLogin(String studentId,String password);
}
