package com.caojiawangduocongdemo.utils.leeCode;

/**
 * @Classname MaoPao
 * @Description 冒泡排序
 * @Date 2020/5/12 0:01
 * @Author caojia
 */
public class MaoPao {
    public static void main(String[] args) {
        int[] array = {23,45,6,29,78};
        for(int i = 0 ; i < array.length-1 ; i ++){
            for(int j = 0 ; j < array.length-i-1; j ++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for (int i:array){
            System.out.println(i);
        }
    }
}
