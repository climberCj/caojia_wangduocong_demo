package com.caojiawangduocongdemo.utils.shejimoshi.factory;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory
 * @ClassName:AbstractFactory
 * @Description:抽象工厂
 * @Author:caojia
 * @Date:2021/6/2323:30
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Weapon createWeapon();
    abstract Transportation createTransportation();
}
