package com.caojiawangduocongdemo.utils.proxy.staticProxy;

/**
 * @Classname ProxyStar
 * @Description 代理角色，将统一的流程控制放到此类中来
 * @Date 2020/5/4 10:49
 * @Author caojia
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star){
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("经纪人面谈");
    }

    @Override
    public void signContract() {
        System.out.println("经纪人签合同");
    }

    @Override
    public void bookTicket() {
        System.out.println("经纪人订票");
    }

    @Override
    public void sing() {
        star.sing();//真正的业务核心由真实角色来实现
    }

    @Override
    public void collectMoney() {
        System.out.println("经纪人收尾款");
    }
}
