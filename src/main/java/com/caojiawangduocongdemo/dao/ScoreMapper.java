package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Score;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@Component
public interface ScoreMapper {
    int deleteByPrimaryKey(String sysid);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String sysid);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    @Select("select t.score from score t where t.studentId = #{studentId} order by t.submitTime DESC")
    List<Score> findLast(String studentId);
}