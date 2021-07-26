package com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza.CheekPizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza.ChinaPizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza.GreekPizza;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza.Pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:SimpleFactory
 * @Description: 制作披萨的工厂（简单工厂），将制作披萨的过程封装起来，便于扩展
 * @Author:caojia
 * @Date:2021/7/200:15
 */
public class SimpleFactory {
    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        do{
            //这样写有问题，匹配到一种类型的披萨就停止了，不能循环匹配，break退出循环
            switch (orderType){
                case "greek":
                    pizza = new GreekPizza();
                    pizza.setName("希腊披萨");
                    break;
                case "cheek":
                    pizza = new CheekPizza();
                    pizza.setName("奶酪披萨");
                    break;
                case "china":
                    pizza = new ChinaPizza();
                    pizza.setName("中国风");
                    break;
            }
            return pizza;
        }while (true);
    }
}
