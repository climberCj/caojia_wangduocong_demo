package com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.order.OrderPizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:PizzaStore
 * @Description:
 * @Author:caojia
 * @Date:2021/7/200:25
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
    }
}
