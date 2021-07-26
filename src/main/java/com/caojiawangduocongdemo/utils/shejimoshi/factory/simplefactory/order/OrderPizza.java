package com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.order;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.SimpleFactory;
import com.caojiawangduocongdemo.utils.shejimoshi.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.factory.vv
 * @ClassName:OrderPizza
 * @Description:
 * @Author:caojia
 * @Date:2021/7/200:08
 */
public class OrderPizza {
    private SimpleFactory simpleFactory;
    public OrderPizza(SimpleFactory simpleFactory){
        this.setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory){
        //此处是写死的，可以做成用户输入形式
        String orderType = getOrderType();
        Pizza pizza = simpleFactory.createPizza(orderType);
        if(pizza != null){
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }else{
            System.out.println("订购披萨失败！！！");
        }
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
