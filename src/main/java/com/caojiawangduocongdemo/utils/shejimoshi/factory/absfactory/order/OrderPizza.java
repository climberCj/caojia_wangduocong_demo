package com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.order;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.factory.AbsFactory;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.order
 * @ClassName:OrderPizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/2123:41
 */
public class OrderPizza {
    private AbsFactory absFactory;

    public OrderPizza(AbsFactory absFactory){
        this.absFactory = absFactory;
        String orderType = null;
        do {
            orderType = getOrderType();
            Pizza pizza = absFactory.createPizza(orderType);
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购失败！！");
                break;
            }
        }while (true);
    }

    private String getOrderType(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请用户输入订购的披萨类型");
            String line = br.readLine();
            if(line != null){
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
