package com.caojiawangduocongdemo.service.student.impl;

import com.caojiawangduocongdemo.common.BizException;
import com.caojiawangduocongdemo.dao.StudentMapper;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import com.caojiawangduocongdemo.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        return studentMapper.findByStudentName(studentName);
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
    public PageInfo<Student> sPage(int page, int pageSize, String q, String stuStatus) {
        PageInfo<Student> result = new PageInfo<>();
        result.setTotal(studentMapper.count(q, stuStatus));
        result.setPageSize(pageSize);
        result.setPageNum(page);
        if (result.getTotal() > 0) {
            result.setList(studentMapper.page((page-1)*pageSize, pageSize, q));
        }
        return result;
    }

    @Override
    public void add(Student student) {

            studentMapper.insert(student);

    }
    /**
     *
     * @param sysid
     * @param studentId
     * @param studentName
     * @param sclass
     * @param stupic
     * @param result
     */


    @Override
    public void insert(String sysid, String studentId, String studentName, String sclass, String stupic, int result,String teacherId,String password) {
        if (studentId == null||studentId.isEmpty()){
            throw new BizException("学号不能为空");
        }else
        if ( studentName==null||studentName.isEmpty()){
            throw new BizException("学生姓名不能为空");
        }else if (sclass==null||sclass.isEmpty()){
            throw new BizException("班级不能为空");
        }else if (studentMapper.countBySudentId(studentId)>0){
            throw new BizException("该学号已存在");
        }
        Student student=new Student();
        student.setSysid(UUID.randomUUID().toString());
        student.setStudentname(studentName);
        student.setStudentid(studentId);
        student.setSclass(sclass);
        student.setStupic(stupic);
        student.setResult(result);
        student.setTeacherid(teacherId);
        student.setPassword(password);
        studentMapper.insert(student);
    }

    /**
     * 编辑学生信息
     *
     * @param sysid
     * @param scalss
     * @param stupic
     * @param result
     */
    @Override
    public void updateBySysid(String sysid, String scalss, String stupic, int result) {
        Student student = studentMapper.selectByPrimaryKey(sysid);
        student.setSclass(scalss);
        student.setStupic(stupic);
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

    /**
     * 逻辑性删除
     *
     * @param sysid
     */
    @Override
    public void updateStatus(String sysid) {
        studentMapper.updateStatuds(sysid);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.findAll();

    }
}
