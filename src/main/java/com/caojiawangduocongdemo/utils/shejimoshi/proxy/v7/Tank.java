package com.caojiawangduocongdemo.utils.shejimoshi.proxy.v7;

import java.beans.XMLEncoder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy
 * @ClassName:Tank
 * @Description: jdk动态代理
 *               存在一定的缺陷：即只能为接口生成代理类
 * @Author:caojia
 * @Date:2021/6/2422:54
 */
public class Tank implements Moveable{
    @Override
    public void move() {
        System.out.println("Tank moving kalakalakala...");
        //模拟坦克移动了一段时间
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Tank tank = new Tank();

        Moveable m = (Moveable) Proxy.newProxyInstance(tank.getClass().getClassLoader(), new Class[]{Moveable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法" + method.getName()+"开始运行了");
                long start = System.currentTimeMillis();
                Object o = method.invoke(tank,args);
                long end = System.currentTimeMillis();
                System.out.println("方法"+ method.getName() + "结束了");
                System.out.println("坦克运行时间："+(end-start));
                return o;
            }
        });
        m.move();
    }
}

interface Moveable{
    void move() throws InterruptedException;
}
