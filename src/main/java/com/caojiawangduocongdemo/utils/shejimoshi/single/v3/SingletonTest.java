package com.caojiawangduocongdemo.utils.shejimoshi.single.v3;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.single.v3
 * @ClassName:SingletonTest
 * @Description: 静态内部类
 * @Author:caojia
 * @Date:2021/7/1715:47
 */
public class SingletonTest {
    public static void main(String[] args) {
        //创建100个线程
        for(int i = 0 ; i < 100 ; i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton.getInstance().hashCode());
                }
            }).start();
        }
    }
}

class Singleton{
    private Singleton(){}
    private static final class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
