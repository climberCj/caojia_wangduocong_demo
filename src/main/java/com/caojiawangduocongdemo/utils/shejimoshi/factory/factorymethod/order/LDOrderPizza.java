package com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.order;


import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza.LDCheesePizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza.LDPepperPizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza.Pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.order
 * @ClassName:LDOrderPizza
 * @Description: 工厂方法模式：将对象的实例化推迟到子类
 * @Author:caojia
 * @Date:2021/7/2122:47
 */
public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheese".equalsIgnoreCase(orderType)){
            pizza = new LDCheesePizza();
        }else if("pepper".equalsIgnoreCase(orderType)){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
