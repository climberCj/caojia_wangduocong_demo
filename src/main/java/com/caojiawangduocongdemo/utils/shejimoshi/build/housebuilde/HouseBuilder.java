package com.caojiawangduocongdemo.utils.shejimoshi.build.housebuilde;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.build
 * @ClassName:HouseBuilder
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2823:06
 */
public abstract class HouseBuilder {
    //组合
    protected House house = new House();

    /**
     * 打地基
     */
    public abstract void buildBasic();

    /**
     * 砌墙
     */
    public abstract void buildWalls();

    /**
     * 封顶
     */
    public abstract void roofed();

    public House buildHouse(){
        return house;
    }
}
