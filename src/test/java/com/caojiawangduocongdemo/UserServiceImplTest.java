package com.caojiawangduocongdemo;

import com.caojiawangduocongdemo.entity.Permission;
import com.caojiawangduocongdemo.entity.Role;
import com.caojiawangduocongdemo.entity.User;
import com.caojiawangduocongdemo.service.custom.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @author caojia
 * @createtime 2019-12-19 16:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void findByUsername(){
        User user = userService.findByUsername("heis");
        Set<Role> roles = user.getRoles();
        for(Role role:roles){
            Set<Permission> permissions = role.getPermissions();
            for (Permission permission:permissions){
                System.out.println(permission.getPermissionName());
            }
            System.out.println(role.getRoleName());
        }
    }
}
