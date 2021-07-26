package com.caojiawangduocongdemo.utils.proxy.staticProxy;

/**
 * @Classname Client
 * @Description 测试类
 * @Date 2020/5/4 10:54
 * @Author caojia
 */
public class Client {
    public static void main(String[] args) {
        Star star = new RealStar();
        Star proxy = new ProxyStar(star);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}
