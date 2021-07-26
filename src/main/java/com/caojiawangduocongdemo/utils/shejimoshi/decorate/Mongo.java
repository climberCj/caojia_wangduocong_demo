package com.caojiawangduocongdemo.utils.shejimoshi.decorate;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.decorate
 * @ClassName:Mongo
 * @Description:定义具体的装饰类-芒果
 * @Author:caojia
 * @Date:2021/7/723:39
 */
public class Mongo extends Condiment{
    private Drink drink;
    public Mongo(Drink drink){
        this.drink = drink;
    }
    @Override
    String description() {
        return this.drink.description() + ",加芒果！";
    }

    @Override
    int price() {
        return this.drink.price() + 6;
    }
}
