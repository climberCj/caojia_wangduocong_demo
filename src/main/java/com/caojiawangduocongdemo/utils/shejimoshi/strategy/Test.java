package com.caojiawangduocongdemo.utils.shejimoshi.strategy;

import java.util.Arrays;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.strategy
 * @ClassName:Test
 * @Description:
 * @Author:caojia
 * @Date:2021/6/1523:24
 */
public class Test {
    public static void main(String[] args) {
        Dog[] o = {new Dog(3,3),new Dog(5,5),new Dog(1,1)};
        Sort<Dog> sort = new Sort<>();
        //策略模式，每次可以定义不同的比较策略
        sort.sort(o, new Compartor<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                if(o1.getHeight() > o2.getHeight()) {
                    return 1;
                } else if(o1.getHeight() < o2.getHeight()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(Arrays.toString(o));
    }
}
