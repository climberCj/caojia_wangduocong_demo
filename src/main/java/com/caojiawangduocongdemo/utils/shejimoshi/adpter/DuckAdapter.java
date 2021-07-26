package com.caojiawangduocongdemo.utils.shejimoshi.adpter;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.adpter
 * @ClassName:DuckAdapter
 * @Description: 鸡只能咯咯叫，鸭子只能嘎嘎叫，现在有一个需求，想让鸡实现嘎嘎叫的功能，只能适配。。。其实就是在鸭子接口上面包一层
 * @Author:caojia
 * @Date:2021/6/3022:35
 */
public class DuckAdapter implements Duck{

    //将Pheasant对象组合进来
    Pheasant pheasant;

    public DuckAdapter(Pheasant pheasant){
        this.pheasant = pheasant;
    }

    @Override
    public void quack() {
        //鸭子嘎嘎叫方法里面实现鸡叫
        pheasant.cluck();
    }

    @Override
    public void fly() {
        pheasant.fly();
    }
}
