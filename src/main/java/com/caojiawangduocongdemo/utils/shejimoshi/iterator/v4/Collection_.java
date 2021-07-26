package com.caojiawangduocongdemo.utils.shejimoshi.iterator.v4;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.iterator
 * @ClassName:Collection_
 * @Description:添加泛型
 * @Author:caojia
 * @Date:2021/6/2922:24
 */
public interface Collection_<E> {
    void add(E e);
    int size();

    Iterator_<E> iterator();
}
