package com.caojiawangduocongdemo.service.teacher.impl;

import com.caojiawangduocongdemo.dao.TeacherMapper;
import com.caojiawangduocongdemo.entity.Teacher;
import com.caojiawangduocongdemo.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caojia
 * @time 下午 9:47
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 教师登录
     * @param teacherId
     * @param password
     * @return
     */
    @Override
    public boolean allowLogin(String teacherId, String password) {
        Teacher teacher = teacherMapper.findByTeacherId(teacherId);
        if(teacher!=null){
            if(password!=null && password.equals(teacher.getPassword())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * 通过老师用户名查询教师对象
     * @param teacherId
     * @return
     */
    @Override
    public Teacher findByTeacherId(String teacherId) {
        return teacherMapper.findByTeacherId(teacherId);
    }
}
