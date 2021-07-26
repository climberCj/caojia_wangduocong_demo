package com.caojiawangduocongdemo.utils.shejimoshi.proxy.v05;

import java.util.Random;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy
 * @ClassName:Tank
 * @Description: 问题1：想记录坦克的移动时间
 *                      最简单的办法就是修改源代码，记录时间
 *               问题2：如果无法修改源代码呢？
 *               可以创建一个代理类RecordTimeProxy将Tank聚合进来
 *               但是这样同样存在一个问题，记录别的事件同样需要创建一个代理类
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

/**
 * 记录移动时间的代理类
 */
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

/**
 * 记录运行日志的代理类
 */
class RecordLogProxy implements Moveable{

    Tank tank;

    public RecordLogProxy(Tank tank){
        this.tank = tank;
    }

    @Override
    public void move() throws InterruptedException {
        System.out.println("Tank start moving");
        tank.move();
        System.out.println("Tank end stopping");
    }
}

interface Moveable{
    void move() throws InterruptedException;
}
