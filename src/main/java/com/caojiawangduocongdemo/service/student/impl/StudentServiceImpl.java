package com.caojiawangduocongdemo.service.student.impl;

import com.caojiawangduocongdemo.dao.StudentMapper;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caojia
 * @time 下午 9:46
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 学生登录
     * @param studentId
     * @param password
     * @return
     */
    @Override
    public boolean allowLogin(String studentId, String password) {
        Student student = studentMapper.findByStudentId(studentId);
        if(student==null){
            return false;
        }else{
            if(password!=null && password.equals(student.getPassword())){
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     * 通过学生用户名查询学生对象
     * @param studentId
     * @return
     */
    @Override
    public Student findByStudentId(String studentId) {
        return studentMapper.findByStudentId(studentId);
    }

    @Override
    public Page<Student> findByPage(int pageNo, int pageSize) {
        Page<Student> page = PageHelper.startPage(pageNo,pageSize);
        return studentMapper.findByPage();
    }
}
