package com.caojiawangduocongdemo.utils.juc;

public class ThreadSafeTest {
    private static int num = 0;

    public static /*synchronized*/ void m1(){
        //synchronized代码块
        synchronized (ThreadSafeTest.class){
            for(int i = 0 ; i < 10000 ; i ++){
                num ++;
            }
        }
    }

    public static class T1 extends Thread{
        @Override
        public void run() {
            ThreadSafeTest.m1();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        T1 t1 = new T1();
        T1 t2 = new T1();
        T1 t3 = new T1();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        //打印的结果不是我们预期的30000，因此线程不安全
        System.out.println(ThreadSafeTest.num);
    }
}
