package com.caojiawangduocongdemo.utils.shejimoshi.proxy.v04;

import java.util.Random;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy
 * @ClassName:Tank
 * @Description: 问题1：想记录坦克的移动时间
 *                      最简单的办法就是修改源代码，记录时间
 *               问题2：如果无法修改源代码呢？
 *               可以创建一个代理类RecordTimeProxy将Tank聚合进来
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

    public static void main(String[] args) throws InterruptedException {
        new RecordTimeProxy(new Tank()).move();
    }
}

class RecordTimeProxy implements Moveable{

    //聚合Tank
    Tank tank;

    public RecordTimeProxy(Tank tank){
        this.tank = tank;
    }

    @Override
    public void move() throws InterruptedException {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("坦克移动的时间为："+(end - start) + "毫秒");
    }
}

interface Moveable{
    void move() throws InterruptedException;
}
