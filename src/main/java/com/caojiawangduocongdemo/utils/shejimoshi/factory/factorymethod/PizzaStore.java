package com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.order.BJOrderPizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.order.LDOrderPizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.order.OrderPizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod
 * @ClassName:PizzaStore
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2122:58
 */
public class PizzaStore {
    public static void main(String[] args) {
        String location = "bj";
        if("bj".equalsIgnoreCase(location)){
            new BJOrderPizza();
        }else{
            new LDOrderPizza();
        }
    }
}
