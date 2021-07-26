package com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza
 * @ClassName:LDPepperPizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2122:36
 */
public class LDPepperPizza extends Pizza{
    @Override
    public void prepare() {
        setName("伦敦的胡椒披萨");
        System.out.println("准备制作伦敦胡椒披萨的原材料");
    }
}
