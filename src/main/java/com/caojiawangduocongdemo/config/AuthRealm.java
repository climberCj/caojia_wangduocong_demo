package com.caojiawangduocongdemo.config;

import com.caojiawangduocongdemo.entity.Permission;
import com.caojiawangduocongdemo.entity.Role;
import com.caojiawangduocongdemo.entity.User;
import com.caojiawangduocongdemo.service.custom.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 为用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取前端输入的用户信息，封装为User对象
        User userWeb = (User) principalCollection.getPrimaryPrincipal();
        //获取前端输入的用户名
        String username = userWeb.getUserName();
        //数据库查询
        User user = userService.findByUsername(username);
        //若存在，则进行授权操作
        if(user!=null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //因为addRoles和addStringPermissions方法需要的参数类型是Collection
            //所以先创建两个collection集合
            Collection<String> rolesCollection = new HashSet<String>();
            Collection<String> perStringCollection = new HashSet<String>();
            //获取user的Role的set集合
            Set<Role> roles = user.getRoles();
            //遍历集合
            for (Role role : roles) {
                System.out.println(role.getRoleName());
                //将每一个role的name装进collection集合
                rolesCollection.add(role.getRoleName());
                //获取每一个Role的permission的set集合
                Set<Permission> permissionSet = role.getPermissions();
                //遍历集合
                for (Permission permission : permissionSet) {
                    //将每一个permission的name装进collection集合
                    perStringCollection.add(permission.getPermissionName());
                }
                //为用户授权
                info.addStringPermissions(perStringCollection);
            }
            //为用户授予角色
            info.addRoles(rolesCollection);
            return info;
        }
        return null;
    }

    /**
     * 认证登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //token携带了用户信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //获取前端输入的用户名
        String userName  = usernamePasswordToken.getUsername();
        //根据用户名查询数据库中对应的记录
        User user = userService.findByUsername(userName);
        //当前realm对象的用户名
        String realmName = getName();
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserName());
        //封装用户信息，构建AuthenticationInfo对象并返回
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getUserPass(),
                credentialsSalt, realmName);
        return authcInfo;
    }
}
