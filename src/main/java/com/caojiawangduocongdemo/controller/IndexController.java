package com.caojiawangduocongdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caojia
 * @time 下午 7:52
 */
@RestController
@RequestMapping
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("为啥在这个类上加了一个@RequestMapping的注解");
        return "hello world";
    }
}
