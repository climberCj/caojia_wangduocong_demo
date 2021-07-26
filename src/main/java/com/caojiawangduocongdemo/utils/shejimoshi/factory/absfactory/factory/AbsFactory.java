package com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.factory;

import com.caojiawangduocongdemo.utils.shejimoshi.factory.absfactory.pizza.Pizza;

public interface AbsFactory {
    Pizza createPizza(String orderType);
}
