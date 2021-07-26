package com.caojiawangduocongdemo.utils.test;

public class Test {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        a = b;
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
