package com.caojiawangduocongdemo.utils.shejimoshi.strategy;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.strategy
 * @ClassName:Cat
 * @Description:
 * @Author:caojia
 * @Date:2021/6/1523:04
 */
public class Cat {
    int food;

    public Cat(int food){
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "food=" + food +
                '}';
    }
}
