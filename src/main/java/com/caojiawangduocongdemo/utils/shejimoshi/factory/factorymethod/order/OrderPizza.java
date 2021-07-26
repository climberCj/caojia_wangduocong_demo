package com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.order;


import com.caojiawangduocongdemo.utils.shejimoshi.factory.factorymethod.pizza.Pizza;

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
public abstract class OrderPizza {
    abstract Pizza createPizza(String orderType);

    //构造函数
    public OrderPizza(){
        Pizza pizza = null;
        String orderType = null;
        do{
            //此处调用createPizza方法，因为该方法为抽象方法，子类需要重写该方法，因此此处调用的是子类重写之后的方法
            orderType = getOrderType();
            pizza = createPizza(orderType);
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("披萨订购失败！");
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
