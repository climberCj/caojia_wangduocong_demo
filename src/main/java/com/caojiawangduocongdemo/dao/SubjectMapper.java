package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Subject;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface SubjectMapper {
    int deleteByPrimaryKey(String sysid);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(String sysid);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    Page<Subject> findByPage(Map<String,Object> conditions);
}