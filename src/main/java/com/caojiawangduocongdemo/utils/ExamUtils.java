/**
 * Copyright (c) 2019, 万维公司 All rights reserved.
 * 万维公司 专有/保密源代码,未经许可禁止任何人通过任何渠道使用、修改源代码.
 */
package com.caojiawangduocongdemo.utils;

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
}
