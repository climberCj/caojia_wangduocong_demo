package com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.cglibproxy
 * @ClassName:CglibProxyFactory
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1423:32
 */
public class CglibProxyFactory implements MethodInterceptor {
    private Object target;

    public CglibProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib前置动作开始");
        Object returnVal = method.invoke(target, objects);
        System.out.println("cglib前置动作结束");
        return returnVal;
    }
}
