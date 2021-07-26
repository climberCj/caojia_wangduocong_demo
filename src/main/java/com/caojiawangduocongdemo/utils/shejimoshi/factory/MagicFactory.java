package com.caojiawangduocongdemo.utils.shejimoshi.factory;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory
 * @ClassName:ModernFactory
 * @Description:具体工厂
 * @Author:caojia
 * @Date:2021/6/2323:40
 */
public class MagicFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Mushroom();
    }

    @Override
    Weapon createWeapon() {
        return new Migicstick();
    }

    @Override
    Transportation createTransportation() {
        return new Broom();
    }
}
