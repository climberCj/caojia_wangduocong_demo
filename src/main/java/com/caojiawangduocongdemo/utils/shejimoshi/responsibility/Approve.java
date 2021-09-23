package com.caojiawangduocongdemo.utils.shejimoshi.responsibility;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.responsibility
 * @ClassName:Approve
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1723:23
 */
public abstract class Approve {
    protected Approve approve;
    protected String name;

    public Approve(String name) {
        this.name = name;
    }

    public void setApprove(Approve approve) {
        this.approve = approve;
    }

    public abstract void approveNext(Request request);

}
