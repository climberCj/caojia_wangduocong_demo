package com.caojiawangduocongdemo.utils;

/**
 * @Classname VolatileTest
 * @Description 内存可见性
 * @Date 2020/4/23 11:07
 * @Author caojia
 */
public class VolatileTest {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while(true){
            synchronized (td){
                if(td.isFlag()){
                    System.out.println("---------------");
                }
            }
        }
    }
}
class ThreadDemo implements Runnable{
    private /*volatile*/ boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag="+flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
