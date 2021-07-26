package com.caojiawangduocongdemo.utils.shejimoshi.adpter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.adpter
 * @ClassName:MainClient
 * @Description:
 * @Author:caojia
 * @Date:2021/6/3022:40
 */
public class MainClient {
    public static void main(String[] args) throws FileNotFoundException {
        Pheasant pheasant = new Chick();
        //成功将鸡适配成了鸭子
        DuckAdapter adapter = new DuckAdapter(pheasant);
        //内部其实是鸡的操作，鸡叫
        adapter.quack();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D://a.txt")));
    }
}
