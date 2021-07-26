package com.caojiawangduocongdemo.utils;

import java.util.*;

public class Main{
    public static void main(String[] args){
        /*Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a);
        Random r = new Random();
        Object[] ls = new Object[a];
        for(int i = 0;i < a;i ++){
            System.out.println(r.nextInt(a));
            ls[i] = r.nextInt(a);
        }
        initArr(ls);*/
        List<Map<String,Integer>> listMap = new ArrayList<>();
        for(int i = 0;i < 20;i ++){
            Map<String,Integer> map = new HashMap<>();
            map.put(i + "",new Random().nextInt(5));
            listMap.add(map);
        }

        Set<Integer> set = new HashSet<>();
        for(Map list: listMap){
            Map<Integer,List<String>> mapList = new HashMap<>();
            list.forEach((k,v) ->{
                System.out.println(k+":"+v);
                set.add((Integer) v);
            });
        }
        //System.out.println(set.toString());
        for(Integer i : set){
            Map<Integer,List<String>> mapList = new HashMap<>();
            List<String> s = new ArrayList<>();
            for(Map list: listMap){
                list.forEach((k,v) ->{
                    if(i == v){
                        s.add(k.toString());
                    }

                });
                mapList.put(i,s);
            }
            mapList.forEach((k,v) -> {
                /*v.forEach(a -> {
                    System.out.println(k+"--"+a);
                });*/
                System.out.println(k+"-"+v.toString());
            });
        }





    }
    //数组的去重并排序
    public static void initArr(Object[] arr){
        List list = new ArrayList();
        for(int i = 0;i < arr.length;i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        Object[] newArr = list.toArray();
        //数组的排序
        Arrays.sort(newArr);
        for(int i = 0;i < newArr.length;i ++){
            System.out.println(newArr[i]);
        }
    }
}
