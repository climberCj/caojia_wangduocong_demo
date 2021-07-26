package com.caojiawangduocongdemo.utils.proxy.dynamicProxy;

/**
 * @Classname RealStar
 * @Description 真实角色，注重业务逻辑
 * @Date 2020/5/4 10:51
 * @Author caojia
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("歌手面谈");
    }

    @Override
    public void signContract() {
        System.out.println("歌手签合同");
    }

    @Override
    public void bookTicket() {
        System.out.println("歌手订票");
    }

    @Override
    public void sing() {
        System.out.println("歌手唱歌");
    }

    @Override
    public void collectMoney() {
        System.out.println("歌手收尾款");
    }
}
