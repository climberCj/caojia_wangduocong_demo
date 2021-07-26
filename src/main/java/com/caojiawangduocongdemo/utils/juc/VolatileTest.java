package com.caojiawangduocongdemo.utils.juc;

/**
 * 测试volatile关键字：该关键字主要作用是内存可见性
 */
public class VolatileTest {
    private static volatile boolean flag = true;

    public static class T extends Thread{
        public T(String name){
            super(name);
        }

        @Override
        public void run() {
            System.out.println("线程"+this.getName()+"come in");
            while(flag){;}
            System.out.println("线程"+this.getName()+"停止了");
        }
    }

    public static void main(String[] args) throws Exception{
        //若上面的共享变量不加volatile关键字，则线程1会会陷入死循环
        //可能1：主线程修改了flag之后，未将其刷入到主内存中，线程t1无法看到
        //可能2：主线程将flag刷新到了主内存，但是线程t1一直读取到的是自己工作内存中的flag值，没有去主内存中读取flag的最新值
        T t = new T("t1");
        t.start();
        //休眠1秒
        Thread.sleep(1000);
        //将flag置为false
        flag = false;
    }
}
