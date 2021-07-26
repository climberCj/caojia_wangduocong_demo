package com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:ChinaPizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/200:28
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的胡椒披萨");
        System.out.println("准备制作北京胡椒披萨的原材料");
    }
}
