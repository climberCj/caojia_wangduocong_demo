package com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.order;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza.BJCheesePizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza.BJPepperPizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza.Pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.order
 * @ClassName:BJOrderPizza
 * @Description:工厂方法模式：将对象的实例化推迟到子类
 * @Author:caojia
 * @Date:2021/7/2122:46
 */
public class BJOrderPizza extends OrderPizza{

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheese".equalsIgnoreCase(orderType)){
            pizza = new BJCheesePizza();
        }else if("pepper".equalsIgnoreCase(orderType)){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
