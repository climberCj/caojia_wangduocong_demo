package com.caojiawangduocongdemo.utils.leeCode;

import java.util.Scanner;

/**
 * @Classname Main04
 * @Description TODO
 * @Date 2020/5/7 12:42
 * @Author caojia
 */
public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            printSon(num);
        }
    }
    public static void printSon(int n){
        if(isSuZhi(n)){
            System.out.println(n+" ");
            return;
        }
        for(int i = 2; i <= n/2 ;i++){
            if(n % i == 0){
                System.out.print(i+" ");
                n = n / i ;
                i = 1;
            }
        }
        System.out.print(n+" ");
    }
    //判断是否是质数
    public static boolean isSuZhi(int n){
        if(n==1)
            return false;
        for(int i = 2 ; i <= n / 2 ;i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
