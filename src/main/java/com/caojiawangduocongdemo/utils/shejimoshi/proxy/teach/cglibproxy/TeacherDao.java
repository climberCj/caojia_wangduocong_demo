package com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.cglibproxy;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.cglibproxy
 * @ClassName:TeacherDao
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1423:31
 */

/**
 * cglib代理，目标对象不需要再去实现接口，可直接获取代理对象
 */
public class TeacherDao {
    public void teach(){
        System.out.println("aaaaaaa");
    }
}
