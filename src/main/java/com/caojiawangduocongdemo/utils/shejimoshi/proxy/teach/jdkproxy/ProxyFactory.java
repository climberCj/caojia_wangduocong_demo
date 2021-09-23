package com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach
 * @ClassName:ProxyFactory
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1422:48
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理前置动作");
                        Object returnVal = method.invoke(target,args);
                        System.out.println("代理后置动作");
                        return returnVal;
                    }
                });
    }

}
