package com.caojiawangduocongdemo.utils.shejimoshi.proxy.v03;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.Random;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy
 * @ClassName:Tank
 * @Description: 问题1：想记录坦克的移动时间
 *                      最简单的办法就是修改源代码，记录时间
 *               问题2：如果无法修改源代码呢？
 *                      用继承？？没问题，但存在问题，若要记录的事件增多，每次都要新建一个类继承Tank??
 * @Author:caojia
 * @Date:2021/6/2422:54
 */
public class Tank implements Moveable{
    @Override
    public void move() {
        //模拟坦克移动了一段时间
        System.out.println("Tank moving kalakalakala...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Tank2().move();
    }
}

class Tank2 extends Tank{
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("坦克移动的时间为："+(end - start) + "毫秒");
    }
}

interface Moveable{
    void move() throws InterruptedException;
}
