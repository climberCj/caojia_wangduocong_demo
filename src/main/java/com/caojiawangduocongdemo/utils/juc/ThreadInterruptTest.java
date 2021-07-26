package com.caojiawangduocongdemo.utils.juc;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断的方式：
 * 1、使用公共变量flag，此时需要注意使用volatile关键字
 * 2、使用java自带的interrupe方法中断
 */
public class ThreadInterruptTest {

    public static class T extends Thread{
        @Override
        public void run() {
            while(true){
                if(this.isInterrupted()){
                    break;
                }
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            while(true){
                try{
                    //模拟死循环
                    TimeUnit.SECONDS.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    this.interrupt();//此处很重要，会将中断标志置为true
                }
                if(this.isInterrupted()){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        T2 t = new T2();
        t.start();
        TimeUnit.SECONDS.sleep(2);
        //调用线程的interrupt方法时，会将线程的中断标志置为true
        //当线程处于阻塞状态，调用线程的interrupt方法会触发InterruptedException异常，并会清楚中断标志
        //也就是说，中断标志置为false
        t.interrupt();

    }
}
