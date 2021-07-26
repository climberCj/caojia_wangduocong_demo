package com.caojiawangduocongdemo.utils.leeCode;

import java.util.Scanner;

/**
 * @Classname Main03
 * @Description TODO
 * @Date 2020/5/7 12:24
 * @Author caojia
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine().substring(2);
            System.out.println(Integer.parseInt(s,16));
        }
    }
}
