package com.caojiawangduocongdemo.utils.shejimoshi.decorate;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.decorate
 * @ClassName:Lemon
 * @Description:定义具体的装饰类-柠檬
 * @Author:caojia
 * @Date:2021/7/723:32
 */
public class Lemon extends Condiment{
    Drink drink;

    public Lemon(Drink drink){
        this.drink = drink;
    }

    //具体的装饰
    @Override
    String description() {
        return this.drink.description() + ",加柠檬！";
    }

    @Override
    int price() {
        return this.drink.price() + 5;
    }
}
