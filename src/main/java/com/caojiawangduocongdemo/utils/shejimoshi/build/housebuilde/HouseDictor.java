package com.caojiawangduocongdemo.utils.shejimoshi.build.housebuilde;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.build
 * @ClassName:HouseDictor
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2823:14
 */
public class HouseDictor {
    //聚合
    private HouseBuilder houseBuilder;

    public HouseDictor(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
