package com.caojiawangduocongdemo.utils.shejimoshi.factory;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory
 * @ClassName:ModernFactory
 * @Description:具体工厂
 * @Author:caojia
 * @Date:2021/6/2323:40
 */
public class ModernFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }

    @Override
    Transportation createTransportation() {
        return new Car();
    }
}
