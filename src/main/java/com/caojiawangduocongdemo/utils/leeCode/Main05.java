package com.caojiawangduocongdemo.utils.leeCode;

import java.util.Scanner;

/**
 * @Classname Main05
 * @Description TODO
 * @Date 2020/5/7 14:53
 * @Author caojia
 */
public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()){
            Double d = sc.nextDouble();
            System.out.println(Math.round(d));
        }
    }
}
