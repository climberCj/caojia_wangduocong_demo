package com.caojiawangduocongdemo.service.custom.impl;

import com.caojiawangduocongdemo.dao.UserMapper;
import com.caojiawangduocongdemo.entity.User;
import com.caojiawangduocongdemo.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caojia
 * @createtime 2019-12-19 16:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
