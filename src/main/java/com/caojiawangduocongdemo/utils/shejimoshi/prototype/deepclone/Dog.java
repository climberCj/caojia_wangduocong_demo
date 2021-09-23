package com.caojiawangduocongdemo.utils.shejimoshi.prototype.deepclone;

import java.io.Serializable;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.prototype.deepclone
 * @ClassName:Dog
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2623:41
 */
public class Dog implements Serializable,Cloneable {

    private static final long serialVersionUID = 4008435252026199012L;
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
