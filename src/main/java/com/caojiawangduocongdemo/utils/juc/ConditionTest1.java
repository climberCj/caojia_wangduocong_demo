package com.caojiawangduocongdemo.utils.juc;

import java.util.concurrent.TimeUnit;

/**
 * 使用Object对象的wait()和notify()方法构建生产者和消费者模型
 */
public class ConditionTest1 {
    private static Object lock = new Object();

    public static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+","+this.getName()+"开始获取锁！");
            synchronized (lock){
                System.out.println(System.currentTimeMillis()+","+this.getName()+"获取锁成功！");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis()+","+this.getName()+"释放锁成功！");
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+","+this.getName()+"开始获取锁！");
            synchronized (lock){
                System.out.println(System.currentTimeMillis()+","+this.getName()+"获取锁成功！");
                lock.notify();
                System.out.println(System.currentTimeMillis()+","+this.getName()+"notify！");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+","+this.getName()+"开始释放锁！");
            }
            System.out.println(System.currentTimeMillis()+","+this.getName()+"释放锁成功！");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //程序执行思路
        //线程t1首先获取到锁，然后调用wait方法t1线程置为等待状态，并释放锁
        //5秒过后，t2线程启动，获取到锁
        //t2调用notify方法，准备唤醒t1线程，notify后t2又休眠了5秒，由程序执行可以看出，t1线程并不能被立即唤醒
        //而是需要等待t2完全执行完synchronized块，释放锁之后，t1才被唤醒
        //需要注意的是，wait()和notify()方法必须要放到synchronized块中才可以
        T1 t1 = new T1();
        t1.setName("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        T2 t2 = new T2();
        t2.setName("t2");
        t2.start();
    }
}
