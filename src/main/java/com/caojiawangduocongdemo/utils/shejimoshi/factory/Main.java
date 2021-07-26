package com.caojiawangduocongdemo.utils.shejimoshi.factory;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory
 * @ClassName:Main
 * @Description:测试类，测试不同的族系
 * @Author:caojia
 * @Date:2021/6/2323:22
 */
public class Main {
    public static void main(String[] args) {
        //现代社会的族系
        /*Car c = new Car();
        c.go();
        Bread b = new Bread();
        b.eat();
        AK47 a = new AK47();
        a.shoot();*/
        //魔法世界的族系怎么扩展？上面的代码重复一遍。。。，这么难受？？？
        //现代世界的具体工厂
        AbstractFactory modern = new ModernFactory();
        //魔法世界的具体工厂
        AbstractFactory magic = new MagicFactory();
        //后续有其他族系方便进行扩展。。。


        Food b = magic.createFood();
        b.eat();
        Weapon w = magic.createWeapon();
        w.shoot();
        Transportation t = magic.createTransportation();
        t.go();

    }
}
