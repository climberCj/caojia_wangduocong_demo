package com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:ChinaPizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/200:28
 */
public class ChinaPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备制作中国风味披萨的原材料");
    }
}
