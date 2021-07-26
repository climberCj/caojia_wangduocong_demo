package com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:GreekPizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/200:05
 */
public class GreekPizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("准备制作希腊披萨的原材料");
    }
}
