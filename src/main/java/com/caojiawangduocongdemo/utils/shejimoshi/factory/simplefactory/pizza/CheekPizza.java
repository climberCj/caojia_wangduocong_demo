package com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:CheekPizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/200:07
 */
public class CheekPizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("准备制作奶酪披萨的原材料");
    }
}
