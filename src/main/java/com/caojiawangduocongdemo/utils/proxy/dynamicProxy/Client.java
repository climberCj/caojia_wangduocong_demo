package com.caojiawangduocongdemo.utils.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2020/5/4 11:15
 * @Author caojia
 */
public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
       /* new Star() {
            @Override
            public void confer() {

            }

            @Override
            public void signContract() {

            }

            @Override
            public void bookTicket() {

            }

            @Override
            public void sing() {
                System.out.println("我是歌手123");
            }

            @Override
            public void collectMoney() {

            }
        }.sing();*/
        StarHandler handler = new StarHandler(realStar);
        //生成代理类 三个参数：被代理类的类加载器，代理类实现的接口的集合，自定义处理器
        Star proxy = (Star) Proxy.newProxyInstance(realStar.getClass().getClassLoader(),new Class[]{Star.class},handler);
        //proxy.bookTicket();
        proxy.sing();
    }
}
