package com.caojiawangduocongdemo.utils.shejimoshi.decorate;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.decorate
 * @ClassName:GreenTea
 * @Description:定义具体的饮料类-绿茶
 * @Author:caojia
 * @Date:2021/7/723:28
 */
public class GreenTea extends Drink{
    @Override
    String description() {
        return "绿茶";
    }

    @Override
    int price() {
        return 12;
    }
}
