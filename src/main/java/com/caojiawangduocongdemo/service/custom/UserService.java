package com.caojiawangduocongdemo.service.custom;

import com.caojiawangduocongdemo.entity.User;

public interface UserService {
    User findByUsername(String username);
}
