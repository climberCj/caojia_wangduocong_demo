package com.caojiawangduocongdemo.utils.shejimoshi.build.housebuilde;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.build
 * @ClassName:HighBuilding
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2823:12
 */
public class HighBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼大厦打地基100米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼大厦砌砖墙");
    }

    @Override
    public void roofed() {
        System.out.println("高楼大厦黄金封顶");
    }
}
