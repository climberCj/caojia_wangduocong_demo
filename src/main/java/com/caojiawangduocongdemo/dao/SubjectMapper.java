package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Subject;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface SubjectMapper {
    int deleteByPrimaryKey(String sysid);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(String sysid);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    Page<Subject> findByPage(Map<String,Object> conditions);

    @Select("select stNo from subject")
    List<String> getStnoList();

    @Select("select * from subject where stStatus = '1'")
    List<Subject> findAll();
}