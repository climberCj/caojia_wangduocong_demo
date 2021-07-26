package com.caojiawangduocongdemo.utils.shejimoshi.adpter;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.adpter
 * @ClassName:Chick
 * @Description:
 * @Author:caojia
 * @Date:2021/6/3022:43
 */
public class Chick implements Pheasant{
    @Override
    public void cluck() {
        System.out.println("小鸡咕咕叫");
    }

    @Override
    public void fly() {
        System.out.println("小鸡也会飞哦");
    }
}
