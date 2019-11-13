package com.caojiawangduocongdemo.service.teacher;

/**
 * @author caojia
 * @time 下午 9:43
 */
public interface TeacherService {
    //教师登录验证
    public boolean allowLogin(String teacherId,String password);
}
