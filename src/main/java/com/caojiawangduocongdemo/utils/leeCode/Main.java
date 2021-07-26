package com.caojiawangduocongdemo.utils.leeCode;

import java.util.Scanner;

/**
 * @Classname Main
 * @Description 输入多行，先输入随机整数的个数，再输入相应个数的整数
 *              返回多行，处理后的结果
 * @Date 2020/5/7 11:28
 * @Author caojia
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //首先输入一个整数，代表几个元素
            int num = sc.nextInt();
            int[] nums = new int[num];
            //将num个随机整数存放到数组中
            for(int i = 0 ; i < nums.length ; i ++){
                nums[i] = sc.nextInt();
            }
            int[] quchong=quchong(nums);
            for(int m = 0 ; m  < 1000; m ++){
                if(quchong[m]==1){
                    System.out.println(m);
                }
            }
        }
    }
    private static int[] quchong(int[] arr){
        int[] temp = new int[1000];
        for(int i = 0 ; i < temp.length ; i ++){
            temp[i] = 0;
        }
        for(int j = 0 ; j < arr.length ;j ++){
            //此操作将会覆盖temp索引重复的值
            temp[arr[j]] = 1;
        }
        return temp;
    }
}
