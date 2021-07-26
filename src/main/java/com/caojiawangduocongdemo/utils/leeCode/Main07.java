package com.caojiawangduocongdemo.utils.leeCode;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Classname Main07
 * @Description 利用了TreeMap的key可排序机制
 * @Date 2020/5/8 14:54
 * @Author caojia
 */
public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Map<Integer,Integer> map = new TreeMap<>();
            int n = sc.nextInt();
            //有四组key-value
            for(int i = 0 ; i  < n ; i ++){
                int key = sc.nextInt();
                int value = sc.nextInt();
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else{
                    map.put(key,value);
                }
            }
            //遍历TreeMap
            for(Map.Entry<Integer,Integer> pp:map.entrySet()){
                System.out.println(pp.getKey()+" "+pp.getValue());
            }
        }
    }
}
