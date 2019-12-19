package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(String perId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String perId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}