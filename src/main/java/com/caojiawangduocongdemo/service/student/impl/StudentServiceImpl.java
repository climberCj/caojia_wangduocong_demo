package com.caojiawangduocongdemo.service.student.impl;

import com.caojiawangduocongdemo.common.BizException;
import com.caojiawangduocongdemo.dao.StudentMapper;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import com.caojiawangduocongdemo.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public List<Student> findBysclass(String sclass) {
        return studentMapper.findBysclass(sclass);
    }

    /**
     * 通过学生姓名查询学生对象
     *
     * @param studentName
     */
    @Override
    public  List<Student>  findByName(String studentName) {
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
            result.setList(studentMapper.page((page - 1) * pageSize, pageSize, q));
        }
        return result;
    }


    /**
     * @param sysid
     * @param studentId
     * @param studentName
     * @param sclass
     * @param stupic
     * @param result
     */


    /**
     *
     * @param sysid
     * @param student
     */
    @Override
    public void updateBySysid(String sysid,Student student) {
       student = studentMapper.selectByPrimaryKey(sysid);
        if (student==null) {
            throw new BizException("该生不存在");
        }
        if (studentMapper.countBySudentIdAndStudentName(student.getStudentid(),student.getStudentname(),student.getStuStatus())!=0){
            throw new BizException("该生已经存在");
        }
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

    @Override
    public int save(Student student) {
        if (studentMapper.countBySudentIdAndStudentName(student.getStudentid(),student.getStudentname(),student.getStuStatus())!=0){
            throw new BizException("该生已经存在");
        }
            if (StringUtils.isEmpty(student.getStudentid())||StringUtils.isEmpty(student.getStudentname())){
                throw new BizException("学生姓名或学号不能为空");
            }
            student.setSysid(UUID.randomUUID().toString());
            student.setPassword("123465");
            return studentMapper.insert(student);
    }
}
