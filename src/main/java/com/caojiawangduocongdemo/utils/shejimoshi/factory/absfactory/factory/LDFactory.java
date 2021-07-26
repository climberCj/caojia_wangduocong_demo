package com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.factory;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.pizza.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.factory
 * @ClassName:LDFactory
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2123:41
 */
public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheese".equalsIgnoreCase(orderType)){
            pizza = new LDCheesePizza();
        }else if("pepper".equalsIgnoreCase(orderType)){
            pizza = new LDPepperPizza();
        }else{
            System.out.println("订购失败");
        }
        return pizza;
    }

}
