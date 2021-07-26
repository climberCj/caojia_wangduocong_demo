package com.caojiawangduocongdemo.utils.shejimoshi.proxy.v01;

import java.util.Random;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.proxy
 * @ClassName:Tank
 * @Description:  问题1：想记录坦克的移动时间
 * @Author:caojia
 * @Date:2021/6/2422:54
 */
public class Tank implements Moveable{
    @Override
    public void move() {
        System.out.println("Tank moving kalakalakala...");
        //模拟坦克移动了一段时间
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

interface Moveable{
    void move() throws InterruptedException;
}
