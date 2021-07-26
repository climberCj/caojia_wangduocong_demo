package com.caojiawangduocongdemo.utils.shejimoshi.single.v2;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.single.v2
 * @ClassName:SingletonTest
 * @Description:
 * @Author:caojia
 * @Date:2021/7/1711:05
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
    private static Singleton single = null;
    private Singleton(){}
    //同步方法，效率低，不建议使用
    public static synchronized Singleton getInstance(){
        if(single == null){
            try {
                //模拟方法执行时间
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            single = new Singleton();
        }
        return single;
    }
    //同步代码块，锁粒度更细，效率相对高，但是线程不安全，多线程环境下不能使用
    /*public static Singleton getInstance(){
        //下面的判断和锁不是一体的，导致同一时间可以有多个线程通过if判断,进行抢占锁，
        //当获得锁的线程执行完成后释放锁，等待的线程继续可以执行下面的new操作，因此多线程下肯定会有多个实例
        if(single == null){
            synchronized (Singleton.class){
                try {
                    //模拟方法执行时间
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                single = new Singleton();
            }
        }
        return single;
    }*/
}
