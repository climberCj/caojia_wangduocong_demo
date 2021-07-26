package com.caojiawangduocongdemo.utils.test;

import org.apache.shiro.crypto.hash.Hash;
import org.hibernate.validator.constraints.EAN;
/**
 * 1、谁重复了？
 * 2、谁分别重复了几次？
 * 3、排序
 */
import java.util.*;

public class Zhangsan {
    public static void main(String[] args) {
        List<Wanju> wanju = new ArrayList<>();
        //Set<Wanju> set = new HashSet<>();
        Wanju wanju1 = new Wanju("car");  //aaa
        Wanju wanju2 = new Wanju("bbb");//bbb
        Wanju wanju3 = new Wanju("bbb");//ccc
        Wanju wanju4 = new Wanju("aaa");//
        Wanju wanju5 = new Wanju("ccc");//
        Wanju wanju6 = new Wanju("aaa");//
        wanju.add(wanju1);
        wanju.add(wanju2);
        wanju.add(wanju3);
        wanju.add(wanju4);
        wanju.add(wanju5);
        wanju.add(wanju6);
        //System.out.println(wanju.size());
        /*for (Wanju w:wanju) {
            set.add(w);
        }
        System.out.println(set.size());*/
        /*Collections.sort(wanju);
        for (Wanju w:wanju){
            System.out.println(w.getName());
        }*/

        HashMap<String,Integer> maps = new HashMap<>(16);
        for(int i = 0 ; i < wanju.size() ; i ++){
            if(maps.containsKey(wanju.get(i).getName())){
                int count = maps.get(wanju.get(i).getName());
                maps.put(wanju.get(i).getName(),count+1);
            }else{
                maps.put(wanju.get(i).getName(),1);
            }
        }

        for(Map.Entry<String,Integer> map:maps.entrySet()){
            System.out.println(map.getKey()+"---"+map.getValue());
        }

        TreeSet<Paixu> set = new TreeSet<Paixu>(new Comparator<Paixu>() {
            @Override
            public int compare(Paixu o1, Paixu o2) {
                if (o1.getCount()!=o2.getCount())
                    return o1.getCount()-o2.getCount();
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(String s:maps.keySet()){
            set.add(new Paixu(maps.get(s),s));
        }
        System.out.println("====================");
        for(Paixu p:set){
            System.out.println(p);
        }

    }
}
class Wanju implements Comparable<Wanju>{
    private String name;

    public Wanju(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wanju wanju = (Wanju) o;
        return Objects.equals(name, wanju.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Wanju{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Wanju o) {
        return o.getName().compareTo(this.getName());
    }
}
class Paixu{
    private Integer count;
    private String name;

    public Paixu(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName()+"---"+this.getCount();
    }
}
/*class Car extends Wanju{

}
class Superman extends Wanju{

}
class Zhizhu extends Wanju{

}
class Bat extends Wanju{

}*/
