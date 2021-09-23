package com.caojiawangduocongdemo.utils.shejimoshi.adpter.springmvc;

//多种Controller实现
public interface Controller {
}

class HttpController implements Controller{
    public void doHttpHandler(){
        System.out.println("do http....");
    }
}

class SimpleController implements Controller{
    public void doSimpleHandler(){
        System.out.println("do simple....");
    }
}

class AnnotationController implements Controller{
    public void doAnnotationHandler(){
        System.out.println("do anno......");
    }
}
