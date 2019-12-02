package com.caojiawangduocongdemo.utils;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author caojia
 * @createtime 2019-11-25 15:11
 */
public class ExamUtils {
    public static int getMax(String[] arr){
        int max = Integer.parseInt(arr[0]);
        for(int i = 0;i < arr.length;i ++){
            if(Integer.parseInt(arr[i])>max){
                max = Integer.parseInt(arr[i]);
            }
        }
        return max;
    }
    public static String getString(Object obj){
        if(obj == null || "".equals(obj.toString())){
            return "";
        }else{
            return obj.toString().trim();
        }

    }
    public static void main(String[] args){
        Random r = new Random();
        System.out.println(r.nextInt(10));

    }
}
