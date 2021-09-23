package com.caojiawangduocongdemo.utils.shejimoshi.template;

public class ClassB extends StatisticTime {
    @Override
    protected String work() {
        int a = 0;
        for (int i = 0 ; i < 100000; i ++) {
            a += i;
        }
        return Integer.valueOf(a).toString();
    }
}
