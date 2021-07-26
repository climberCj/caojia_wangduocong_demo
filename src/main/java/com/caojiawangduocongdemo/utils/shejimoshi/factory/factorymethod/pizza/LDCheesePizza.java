package com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza
 * @ClassName:LDCheesePizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2122:36
 */
public class LDCheesePizza extends Pizza{
    @Override
    public void prepare() {
        setName("伦敦的奶酪披萨");
        System.out.println("准备制作伦敦奶酪披萨的原材料");
    }
}
