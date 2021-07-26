package com.caojiawangduocongdemo.utils.shejimoshi.decorate;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.decorate
 * @ClassName:MainClient
 * @Description:
 * @Author:caojia
 * @Date:2021/7/723:41
 */
public class MainClient {
    public static void main(String[] args) {
        //首先定义一种饮料
        Drink drink = new BlackTea();
        //再进行装饰 例如：红茶添加柠檬
        drink = new Lemon(drink);
        //再添加芒果
        drink = new Mongo(drink);

        System.out.println(drink.description() + drink.price());

        //芒果加双份柠檬绿茶如何装饰？？Lemon和Mongo可以随意更换位置
        Drink drink1 = new Lemon(new Mongo(new Lemon(new GreenTea())));
        System.out.println(drink1.description() + drink1.price());
    }
}
