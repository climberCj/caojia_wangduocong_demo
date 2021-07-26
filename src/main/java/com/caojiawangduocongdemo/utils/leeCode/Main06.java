package com.caojiawangduocongdemo.utils.leeCode;

import java.util.*;

/**
 * @Classname Main06
 * @Description 输入一个字符，求字符串中该字符的个数
 * @Date 2020/5/7 15:22
 * @Author caojia
 */
public class Main06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            //字符串
            String s1 = sc.nextLine().toUpperCase();
            //字符
            String s2 = sc.nextLine().toUpperCase();
            System.out.println(getSum(s1,s2.charAt(0)));
        }
    }
    private static int getSum(String str,char c){
        int sum = 0;
        for(int i = 0 ; i < str.length() ; i ++){
            if(str.charAt(i)==c){
                sum++;
            }
        }
        return sum;
    }
}
