package com.caojiawangduocongdemo.utils.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Classname StarHandler
 * @Description JDK动态代理，核心处理器
 * @Date 2020/5/4 11:10
 * @Author caojia
 */
public class StarHandler implements InvocationHandler {
    private Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    /**
     *
     * @param proxy 被代理的类
     * @param method 被调用的方法
     * @param args 被调用方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("真正的方法执行前");
        System.out.println("面谈、签合同、订机票");
        if(method.getName().equals("sing")){
            method.invoke(realStar,args);
        }
        System.out.println("真正的方法执行后");
        System.out.println("收尾款");
        return object;
    }
}
