package com.caojiawangduocongdemo.utils;

/**
 * @Classname AtomicTest
 * @Description TODO
 * @Date 2020/4/23 11:22
 * @Author caojia
 */
public class AtomicTest {
    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        for(int i = 0; i < 10; i++){
            new Thread(tt).start();
        }
    }
}
class ThreadTest implements Runnable{
    private volatile int initValue = 0;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
            System.out.println(getInitValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getInitValue() {
        return initValue++;
    }

    public void setInitValue(int initValue) {
        this.initValue = initValue;
    }
}
