package com.caojiawangduocongdemo.utils.shejimoshi.strategy;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.strategy
 * @ClassName:sort
 * @Description:通用排序方法
 * @Author:caojia
 * @Date:2021/6/1523:00
 */
public class Sort<T> {
    public void sort(T[] o,Compartor<T> compartor){
        for(int i = 0 ; i < o.length ; i ++){
            int minPos = i;
            for(int j = i + 1 ; j < o.length ; j ++){
                if(compartor.compare(o[minPos],o[j]) > 0){
                    minPos = j;
                }
            }
            T temp = o[minPos];
            o[minPos] = o[i];
            o[i] = temp;
        }
    }
}
