package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public interface SubjectMapper {
    int deleteByPrimaryKey(Integer stid);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer stid);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}