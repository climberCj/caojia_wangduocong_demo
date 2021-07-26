package com.caojiawangduocongdemo.utils.leeCode;

import java.util.*;

/**
 * @Classname Main08
 * @Description 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *              集合使用特点：Set集合的去重
 *                           List集合的有序性
 *                           HashSet的add方法返回boolean型，如果几何中不存在该元素，则添加
 * @Date 2020/5/8 15:05
 * @Author caojia
 */
public class Main08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            String s = String.valueOf(a);
            List<Character> list = new ArrayList<>();
            Set<Character> set = new HashSet<>();
            for(int i = s.length()-1 ; i >=0; i --){
                if(set.add(s.charAt(i))){
                    list.add(s.charAt(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for(Character c:list){
                sb.append(c);
            }
            System.out.println(Integer.parseInt(sb.toString()));
        }
    }
}
