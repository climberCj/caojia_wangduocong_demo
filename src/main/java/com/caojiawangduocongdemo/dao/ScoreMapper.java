package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Score;
import org.springframework.stereotype.Component;

@Component
public interface ScoreMapper {
    int deleteByPrimaryKey(String sysid);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String sysid);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}