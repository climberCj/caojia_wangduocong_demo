package com.caojiawangduocongdemo.utils.leeCode;

import java.util.Scanner;

/**
 * @Classname Main02
 * @Description TODO
 * @Date 2020/5/7 11:59
 * @Author caojia
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            printLine(str);
        }
    }
    public static void printLine(String s){
        while(s.length()>=8){
            System.out.println(s.substring(0,8));
            s = s.substring(8);
        }
        if(s.length()<8&&s.length()>0){
            s = s+"00000000";
            System.out.println(s.substring(0,8));
        }
    }
}
