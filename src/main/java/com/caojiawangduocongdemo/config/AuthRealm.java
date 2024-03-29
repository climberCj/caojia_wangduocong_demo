package com.caojiawangduocongdemo.config;

import com.caojiawangduocongdemo.entity.Permission;
import com.caojiawangduocongdemo.entity.Role;
import com.caojiawangduocongdemo.entity.User;
import com.caojiawangduocongdemo.service.custom.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 用来验证当前登录的用户，获取认证信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //数据库查询
        User user = userService.findByUsername(principalCollection.getPrimaryPrincipal().toString());
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
     * 用来为当前登陆成功的用户授予权限和角色
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName  = authenticationToken.getPrincipal().toString();
        //根据用户名查询数据库中对应的记录
        User user = userService.findByUsername(userName);
        if(user!=null){
            // 把当前用户存到session中
            SecurityUtils.getSubject().getSession().setAttribute("custom", user);
            //当前realm对象的用户名
            String realmName = getName();
            //盐值
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserName());
            //封装用户信息，构建AuthenticationInfo对象并返回
            SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPass(), credentialsSalt, realmName);
            return authcInfo;
        }else{
            return null;
        }
    }
}
