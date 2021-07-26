package com.caojiawangduocongdemo.utils.shejimoshi.single.v1;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.single
 * @ClassName:Singleton
 * @Description: 模拟多线程下简单懒汉式线程不安全场景
 * @Author:caojia
 * @Date:2021/7/1710:45
 */
public class SingletonTest {
    public static void main(String[] args) {
        /*Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance==instance2);*/

        //创建10个线程
        for(int i = 0 ; i < 10 ; i ++){
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
    private static Singleton single = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(single == null){
            /*try {
                //模拟方法执行时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            single = new Singleton();
        }
        return single;
    }
}
