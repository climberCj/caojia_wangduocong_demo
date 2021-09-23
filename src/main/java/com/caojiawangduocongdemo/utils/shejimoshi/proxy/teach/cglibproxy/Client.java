package com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.cglibproxy;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.cglibproxy
 * @ClassName:Client
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1423:38
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao target = new TeacherDao();
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(target);
        TeacherDao proxyInstance = (TeacherDao)(cglibProxyFactory.getProxyInstance());
        proxyInstance.teach();
    }
}
