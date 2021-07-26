package com.caojiawangduocongdemo.utils.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest2 {
    private static ReentrantLock lock = new ReentrantLock(false);
    private static Condition condition = lock.newCondition();

    public static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+""+this.getName()+"开始获取锁！");
            lock.lock();
            try{
                System.out.println(System.currentTimeMillis()+""+this.getName()+"获取锁成功！");
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println(System.currentTimeMillis()+","+this.getName()+"释放锁成功！");
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+","+this.getName()+"开始获取锁！");
            lock.lock();
            try{
                System.out.println(System.currentTimeMillis()+","+this.getName()+"获取锁成功！");
                System.out.println(System.currentTimeMillis()+","+this.getName()+"准备释放锁！");
                condition.signal();
                System.out.println(System.currentTimeMillis()+","+this.getName()+"signal！");
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println(System.currentTimeMillis()+","+this.getName()+"释放锁成功！");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        T1 t1 = new T1();
        t1.setName("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        T2 t2 = new T2();
        t2.setName("t2");
        t2.start();
    }
}
