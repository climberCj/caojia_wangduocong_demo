package com.caojiawangduocongdemo.utils.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLockTest {

    private static int num = 0;

    //可重入锁
    private static ReentrantLock lock = new ReentrantLock();

    public static void m(){
        //获取锁
        //可重入：同一个线程可以多次获取同一把锁
        //lock和unlock要成对存在，获取了几次就要释放几次
        lock.lock();
        lock.lock();
        try{
            for(int i = 0 ; i < 10000 ; i ++){
                num ++;
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public static class T extends Thread{
        @Override
        public void run() {
            ReentrantLockTest.m();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(ReentrantLockTest.num);
    }
}
