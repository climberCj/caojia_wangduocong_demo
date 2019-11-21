package com.caojiawangduocongdemo.service.student.impl;

import com.caojiawangduocongdemo.common.Page;
import com.caojiawangduocongdemo.dao.StudentMapper;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
     *
     * @param studentId
     * @param password
     * @return
     */
    @Override
    public boolean allowLogin(String studentId, String password) {
        Student student = studentMapper.findByStudentId(studentId);
        if (student == null) {
            return false;
        } else {
            if (password != null && password.equals(student.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 通过学生用户名查询学生对象
     *
     * @param studentId
     * @return
     */
    @Override
    public Student findByStudentId(String studentId) {
        return studentMapper.findByStudentId(studentId);
    }

    /**
     * 通过学生用户名查询学生对象
     *
     * @param sclass
     * @return
     */
    @Override
    public Student findBysclass(String sclass) {
       return studentMapper.findBysclass(sclass);
    }

    /**
     * 通过学生姓名查询学生对象
     *
     * @param studentName
     */
    @Override
    public Student findByName(String studentName) {
      return   studentMapper.findByStudentName(studentName);
    }

    /**
     * 学生分页
     *
     * @param page
     * @param pageSize
     * @param q
     * @return
     */
    @Override
    public Page<Student> sPage(int page, int pageSize, String q) {
        Page<Student> result = new Page<>();
        result.setTotal(studentMapper.count(q));
        result.setPageSize(pageSize);
        result.setCurrent(page);
        if (result.getTotal() > 0) {
            result.setData(studentMapper.page(page, pageSize, q));
        }
        return result;
    }

    /**
     * 添加学生信息
     *
     * @param student
     */
    @Override
    public void insert(Student student) {
       studentMapper.insert(student);

    }

    /**
     * 编辑学生信息
     *
     * @param sysid
     * @param studentname
     * @param scalss
     * @param result
     */
    @Override
    public void updateBySysid(String sysid, String studentname, String scalss, int result) {
        Student student = studentMapper.selectByPrimaryKey(sysid);
        student.setStudentname(studentname);
        student.setSclass(scalss);
        student.setResult(result);
        studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 删除学生信息
     *
     * @param sysid
     */
    @Override
    public void delete(String sysid) {
        studentMapper.deleteByPrimaryKey(sysid);
    }
}
