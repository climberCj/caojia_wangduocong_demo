package com.caojiawangduocongdemo.utils.leeCode;

import java.util.Scanner;

/**
 * @Classname Main09
 * @Description TODO
 * @Date 2020/5/8 17:49
 * @Author caojia
 */
public class Main09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(getLen(str));
        }
    }
    private static int getLen(String s){
        int[] arr = new int[128];
        for(int i = 0 ; i < s.length();i ++){
            arr[s.charAt(i)] = 1;
        }
        int len = 0;
        for(int i = 0;i < arr.length;i ++){
            if(arr[i]==1){
                len++;
            }
        }
        return len;
    }
}
