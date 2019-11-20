package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {
    int deleteByPrimaryKey(String sysid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sysid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    //分页
    List<Student> page(@Param("page") int page, @Param("pageSize") int pageSize, @Param("q") String q);

    //通过学生账号查询
    Student findByStudentId(String studentId);

    //通过学生姓名查询
    @Select("select * from student where studentname=#{studentName} order by result desc")
    @ResultMap("BaseResultMap")
    Student findByStudentName(@Param("studentname") String findByStudentName);

    //    long countStudentName(@Param("studentName")String studentName);
    long cout(@Param("q") String q);

    //通过学生班级查询
    @Select("select * from student where sclass=#{sclass} order by result desc")
    @ResultMap("BaseResultMap")
    Student findBysclass(String sclass);
}