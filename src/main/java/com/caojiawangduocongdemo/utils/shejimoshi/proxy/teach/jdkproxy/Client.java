package com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.jdkproxy;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach
 * @ClassName:Client
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1422:53
 */
public class Client {
    public static void main(String[] args) {
        ITeachDao target = new TeachDao();

        ProxyFactory proxyFactory = new ProxyFactory(target);

        //创建代理对象
        ITeachDao proxyInstance = (ITeachDao)(proxyFactory.getProxyInstance());

        proxyInstance.teach();
    }
}
