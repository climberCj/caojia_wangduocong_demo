package com.caojiawangduocongdemo.utils.shejimoshi.iterator.v4;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.iterator.v2
 * @ClassName:Main
 * @Description: 如何对容器进行遍历？？？
 * @Author:caojia
 * @Date:2021/6/2923:08
 */
public class Main {
    public static void main(String[] args) {
        Collection_<String> c = new ArrayList_<String>();
        for(int i = 0 ; i < 20 ; i ++){
            c.add(new String(i + "s"));
        }
        System.out.println("容器中的元素个数为："+ c.size());

        //遍历元素
        Iterator_<String> iterator = c.iterator();
        while(iterator.hasNext()){
            String o = iterator.next();
            System.out.print(o+" ");
        }
    }
}
