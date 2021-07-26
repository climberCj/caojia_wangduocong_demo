package com.caojiawangduocongdemo.utils.juc.ABCABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用三个线程按顺序输出 ABC ABC ABC
 */
public class TestABC {
    public static void main(String[] args) {
        //思路：三个线程，三个不同的队列（Condition）A唤醒B，B唤醒C
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        new Thread(() ->{
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("A");
                    condition2.signal();
                    condition1.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
                try {
                    condition3.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("C");
                try {
                    condition1.signal();
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t3").start();
    }
}
