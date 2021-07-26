package com.caojiawangduocongdemo.utils.proxy.dynamicProxy;

/**
 * @Classname Star
 * @Description 静态代理接口，相当于抽象角色，定义代理角色和真实角色的公共对外方法
 * @Date 2020/5/4 10:46
 * @Author caojia
 */
public interface Star {
    //面谈
    void confer();
    //签合同
    void signContract();
    //订票
    void bookTicket();
    //唱歌
    void sing();
    //收尾款
    void collectMoney();
}
