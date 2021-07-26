package com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.factory;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.pizza.BJCheesePizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.pizza.BJPepperPizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.factory
 * @ClassName:BJFactory
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2123:40
 */
public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheese".equalsIgnoreCase(orderType)){
            pizza = new BJCheesePizza();
        }else if("pepper".equalsIgnoreCase(orderType)){
            pizza = new BJPepperPizza();
        }else{
            System.out.println("订购失败");
        }
        return pizza;
    }

}
