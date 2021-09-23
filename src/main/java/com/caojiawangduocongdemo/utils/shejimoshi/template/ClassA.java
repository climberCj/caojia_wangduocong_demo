package com.caojiawangduocongdemo.utils.shejimoshi.template;


public class ClassA extends StatisticTime {
    @Override
    protected String work() {
        String s = "abc";
        for(int i = 0 ; i < 10000; i ++){
            s += i;
        }
        return s;
    }
}
