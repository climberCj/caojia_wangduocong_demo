package com.caojiawangduocongdemo.utils.shejimoshi.proxy.v02;

import java.util.Random;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy
 * @ClassName:Tank
 * @Description: 问题1：想记录坦克的移动时间
 *                      最简单的办法就是修改源代码，记录时间
 *               问题2：如果无法修改源代码呢？
 * @Author:caojia
 * @Date:2021/6/2422:54
 */
public class Tank implements Moveable{
    @Override
    public void move() {
        //方法1
        long start = System.currentTimeMillis();

        System.out.println("Tank moving kalakalakala...");
        //模拟坦克移动了一段时间
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("坦克移动的时间为："+(end - start));
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Moveable{
    void move() throws InterruptedException;
}
