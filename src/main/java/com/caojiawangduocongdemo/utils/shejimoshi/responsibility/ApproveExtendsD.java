package com.caojiawangduocongdemo.utils.shejimoshi.responsibility;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.responsibility
 * @ClassName:ApproveExtendsA
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1723:26
 */
public class ApproveExtendsD extends Approve{

    public ApproveExtendsD(String name) {
        super(name);
    }

    @Override
    public void approveNext(Request request) {
        if(request.getPrice() > 30000){
            System.out.println(this.name + "需要审批！");
        }else{
            this.approve.approveNext(request);
        }
    }
}
