package com.caojiawangduocongdemo.service.student.impl;

import com.caojiawangduocongdemo.dao.StudentMapper;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author DC
 * @time 16：00
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
    /**
     * 通过学生用户名查询学生对象
     * @param sclass
     * @return
     */
    @Override
    public void findBysclass(String sclass) {
        studentMapper.findBysclass(sclass);

    }

    @Override
    public void findByName(String studentName) {
        studentMapper.findByStudentName(studentName);
    }

    @Override
    public Page<Student> sPage(int page, int pageSize, String q) {
        Page<Student> result=new Pa
        return null;
    }

    @Override
    public void inser(Student student) {

    }

    @Override
    public void updateBySysid(String sysid, String studentname, String scalss, int result) {

    }

    @Override
    public void delete(String sysid) {

    }
}
