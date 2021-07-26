package com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.factory.BJFactory;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.factory.LDFactory;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.order.OrderPizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory
 * @ClassName:PizzaStore
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2123:49
 */
public class PizzaStore {
    public static void main(String[] args) {
        String location = "bj";
        if("ld".equalsIgnoreCase(location)){
            new OrderPizza(new LDFactory());
        }else{
            new OrderPizza(new BJFactory());
        }
    }
}
