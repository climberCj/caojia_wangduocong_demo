package com.caojiawangduocongdemo;

import com.caojiawangduocongdemo.config.redis.RedisUtils;
import com.caojiawangduocongdemo.entity.Permission;
import com.caojiawangduocongdemo.entity.Role;
import com.caojiawangduocongdemo.entity.User;
import com.caojiawangduocongdemo.service.custom.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

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

    @Test
    public void getCache(){
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists("caojia");
        User user = null;
        if(hasKey){
            //从缓存中获取数据
            Object value = redisUtils.get("caojia");
            logger.info("缓存中的数据："+value);
        }else{
            logger.info("从数据库中获取数据");
            user = userService.findByUsername("caojia");
            //存入缓存
            redisUtils.set("caojia",user);
            logger.info("数据插入缓存："+user);
        }
    }

    @Test
    public void getPass(){
        //2次加密
        String pass = new Md5Hash(new Md5Hash("123456","heis")).toHex();
        System.out.println(pass);
    }
}
