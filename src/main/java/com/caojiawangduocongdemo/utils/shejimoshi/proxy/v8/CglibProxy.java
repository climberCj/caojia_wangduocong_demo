package com.caojiawangduocongdemo.utils.shejimoshi.proxy.v8;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.beans.XMLEncoder;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy.v8
 * @ClassName:CglibProxy
 * @Description:  cglib动态代理
 * @Author:caojia
 * @Date:2021/6/2822:43
 */
public class CglibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("method before");
        Object result = null;
        result = methodProxy.invokeSuper(o,objects);
        System.out.println("method after");
        return result;
    }
}

class Tank{
    public void move(){
        System.out.println("tank moving kalakalakkkk");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
