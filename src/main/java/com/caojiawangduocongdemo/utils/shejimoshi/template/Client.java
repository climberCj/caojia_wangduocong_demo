package com.caojiawangduocongdemo.utils.shejimoshi.template;

public class Client {
    public static void main(String[] args) {
        StatisticTime a = new ClassA();
        StatisticTime b = new ClassB();
        System.out.println("ClassA的work方法执行时间为："+a.statistic());
        System.out.println("ClassB的work方法执行时间为："+b.statistic());
    }
}
