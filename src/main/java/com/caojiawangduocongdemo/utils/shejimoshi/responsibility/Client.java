package com.caojiawangduocongdemo.utils.shejimoshi.responsibility;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.responsibility
 * @ClassName:Client
 * @Description:
 * @Author:caojia
 * @Date:2021/9/1723:35
 */
public class Client {
    public static void main(String[] args) {
        Request request = new Request(1,11000);

        ApproveExtendsA approveA = new ApproveExtendsA("王主任");
        ApproveExtendsB approveB = new ApproveExtendsB("张院长");
        ApproveExtendsC approveC = new ApproveExtendsC("丁副校长");
        ApproveExtendsD approveD = new ApproveExtendsD("李校长");

        //设置每一个审批对象的下一个审批者 形成环状 责任链
        //自己能处理就处理自己的部分，不能处理将由下个对象处理
        approveA.setApprove(approveB);
        approveB.setApprove(approveC);
        approveC.setApprove(approveD);
        approveD.setApprove(approveA);

        approveA.approveNext(request);
    }
}
