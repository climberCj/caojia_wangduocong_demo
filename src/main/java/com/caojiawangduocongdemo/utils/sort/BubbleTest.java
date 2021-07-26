package com.caojiawangduocongdemo.utils.sort;

import java.util.Arrays;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.sort
 * @ClassName:BubbleTest
 * @Description:冒泡排序：
 * @Author:caojia
 * @Date:2021/6/1623:27
 */
public class BubbleTest {
    public static void main(String[] args) {
        int[] a = {2,5,7,1,4,3,8};
        long startTime = System.currentTimeMillis();
        sort2(a);
        System.out.println(Arrays.toString(a));
        long endTime = System.currentTimeMillis();
        System.out.println("排序所消耗的时间是："+(endTime - startTime));
    }

    public static void sort(int[] array){
        for(int i = array.length - 1 ; i > 0 ; i --){
            for(int j = 0 ; j < i ; j ++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void sort2(int[] array){
        for(int i = 0 ; i < array.length ; i ++){
            for(int j = 0 ; j < array.length - i - 1 ; j ++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
