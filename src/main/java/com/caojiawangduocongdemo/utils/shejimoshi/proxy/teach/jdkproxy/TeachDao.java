package com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach.jdkproxy;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy.teach
 * @ClassName:TeachDao
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1422:47
 */
public class TeachDao implements ITeachDao{
    @Override
    public void teach() {
        System.out.println("代理老师上课中。。。");
    }
}
