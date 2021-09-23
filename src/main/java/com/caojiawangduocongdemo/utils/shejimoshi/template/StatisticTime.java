package com.caojiawangduocongdemo.utils.shejimoshi.template;

/**
 * 模板方法模式抽象类，实现为不同的方法统计执行时间
 */
public abstract class StatisticTime {
    public long statistic(){
        long startTime = System.nanoTime();
        this.work();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    //延迟到具体的子类实现
    protected abstract String work();
}
