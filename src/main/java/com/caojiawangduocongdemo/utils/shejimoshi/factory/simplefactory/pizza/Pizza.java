package com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:Pizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/200:00
 */
public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake(){
        System.out.println(name + "披萨烘焙");
    }

    public void cut(){
        System.out.println(name + "切披萨");
    }

    public void box(){
        System.out.println( name + "披萨打包");
    }

    public void setName(String name){
        this.name = name;
    }
}
