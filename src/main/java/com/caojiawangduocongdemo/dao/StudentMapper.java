package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Student;
import org.apache.ibatis.annotations.*;
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
    @Select("select * from student where studentName=#{studentname} and stuStatus='1' order by result desc")
    @ResultMap("BaseResultMap")
    List<Student> findByStudentName(@Param("studentname") String findByStudentName);

    //    long countStudentName(@Param("studentName")String studentName);
    long count(@Param("q") String q,@Param("stuStatus")String stuStatus);

    @Select("select count(1) from student where studentId=#{studentId} and stuStatus='1' and studentName=#{studentName}")
    long countBySudentIdAndStudentName(@Param("studentId")String studentId,@Param("studentName")String studentName,@Param("stuStatus")String stuStatus);

    //通过学生班级查询
    @Select("select * from student where sclass=#{sclass} and stuStatus='1' order by result desc")
    @ResultMap("BaseResultMap")
    List<Student> findBysclass(@Param("sclass") String sclass);

    @Select("select * from student where stuStatus='1' order by result desc")
    @ResultMap("BaseResultMap")
    List<Student> findAll();

    @Update("update student set stuStatus= '0' where sysid=#{sysid}")
    void updateStatuds(@Param("sysid")String sysid);

    @Select("select * from student where teacherId=#{teacherId} order by result sesc")
    @ResultMap("BaseResultMap")
    List<Student> findeByTeacherId(@Param("teacherId")String teacherId);

}