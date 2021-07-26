package com.caojiawangduocongdemo.utils.juc;

import java.util.concurrent.TimeUnit;

/**
 * 用户线程和守护线程
 * 当jvm中只有守护线程时，jvm会自动退出
 */
public class DaemonThreadThread {
    public static class T1 extends Thread{
        public T1(String name){super(name);}

        @Override
        public void run() {
            System.out.println(this.getName() + "开始执行，" + (this.isDaemon() ? "我是守护线程" : "我是用户线程"));
            while(true) {;}
        }
    }

    public static class T2 extends Thread{
        public T2(String name){super(name);}

        @Override
        public void run() {
            System.out.println(this.getName() +".Daemon："+ this.isDaemon());
        }
    }

    public static void main(String[] args) throws Exception{


        /*T1 t1 = new T1("子线程t1");
        //注意：设置线程为守护线程一定要放在start方法之前，放在后面会报异常
        t1.setDaemon(true);
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("主线程结束");*/

        System.out.println("================测试子父线程daemon的默认值==============");
        //线程的daemon的默认值和父线程是一样的
        System.out.println(Thread.currentThread().getName() +".Daemon："+ Thread.currentThread().isDaemon());

        T2 t2 = new T2("线程t2");
        t2.start();

        Thread t3 = new Thread(){
            @Override
            public void run() {
                System.out.println(this.getName() +".Daemon："+ this.isDaemon());
                T2 t4 = new T2("线程t4");
                t4.start();
            }
        };

        t3.setName("线程t3");
        t3.setDaemon(true);
        t3.start();

        TimeUnit.SECONDS.sleep(1);
    }
}
