package com.caojiawangduocongdemo.utils.shejimoshi.build.housebuilde;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.build
 * @ClassName:Client
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2823:17
 */
public class Client {
    public static void main(String[] args) {
        //普通的房子
        CommonHouse commonHouse = new CommonHouse();
        HouseDictor dictor = new HouseDictor(commonHouse);
        dictor.constructHouse();

        //高楼大厦
        HighBuilding highBuilding = new HighBuilding();
        //HouseDictor dictor1 = new HouseDictor(highBuilding);
        dictor.setHouseBuilder(highBuilding);
        dictor.constructHouse();
    }
}
