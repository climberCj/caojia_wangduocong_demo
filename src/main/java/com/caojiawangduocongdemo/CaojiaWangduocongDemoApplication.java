package com.caojiawangduocongdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.caojiawangduocongdemo.dao")
public class CaojiaWangduocongDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaojiaWangduocongDemoApplication.class, args);
    }

}
