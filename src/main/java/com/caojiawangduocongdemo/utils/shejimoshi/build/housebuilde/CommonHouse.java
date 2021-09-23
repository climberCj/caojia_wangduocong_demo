package com.caojiawangduocongdemo.utils.shejimoshi.build.housebuilde;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.build
 * @ClassName:CommonHouse
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2823:08
 */
public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌泥土墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子木头封顶");
    }
}
