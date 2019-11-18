package com.caojiawangduocongdemo.service.teacher;

import com.caojiawangduocongdemo.entity.Teacher;

/**
 * @author caojia
 * @time 下午 9:43
 */
public interface TeacherService {
    //教师登录验证
    public boolean allowLogin(String teacherId,String password);
    //根据用户名查询
    Teacher findByTeacherId(String teacherId);
}
