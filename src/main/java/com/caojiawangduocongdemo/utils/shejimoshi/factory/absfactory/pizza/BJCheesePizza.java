package com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:CheekPizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/200:07
 */
public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京的奶酪披萨");
        System.out.println("准备制作北京奶酪披萨的原材料");
    }
}
