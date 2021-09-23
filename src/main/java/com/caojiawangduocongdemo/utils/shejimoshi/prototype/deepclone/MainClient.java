package com.caojiawangduocongdemo.utils.shejimoshi.prototype.deepclone;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.prototype.deepclone
 * @ClassName:MainClient
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2623:11
 */
public class MainClient {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("多利",20,new Dog("杰克",21));
        Sheep sheep1 = null;
        try {
            //通过对象的序列化和反序列化实现对象的深拷贝
            sheep1 = (Sheep) sheep.deepClone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sheep.getAge().hashCode());
        System.out.println(sheep1.getAge().hashCode());
        System.out.println(sheep.getFriend().hashCode());
        System.out.println(sheep1.getFriend().hashCode());
    }
}
