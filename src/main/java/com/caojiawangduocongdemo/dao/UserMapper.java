package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //通过用户名来查询用户
    User findUserByUsername(String username);
}