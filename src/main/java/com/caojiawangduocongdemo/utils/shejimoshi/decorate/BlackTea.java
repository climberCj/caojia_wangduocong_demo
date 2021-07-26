package com.caojiawangduocongdemo.utils.shejimoshi.decorate;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.decorate
 * @ClassName:BlackTea
 * @Description:定义具体的饮料-红茶
 * @Author:caojia
 * @Date:2021/7/723:26
 */
public class BlackTea extends Drink{
    @Override
    String description() {
        return "红茶";
    }

    @Override
    int price() {
        return 10;
    }
}
