package com.caojiawangduocongdemo.utils.shejimoshi.adpter.springmvc;

public interface HandleAdapter {
    /**
     * 判断是否匹配某一种处理器
     * @param handler
     * @return
     */
    boolean supports(Object handler);

    /**
     * 处理方法
     * @param handler
     */
    void handle(Object handler);
}

/**
 * 不同类型的适配器类
 */
class HttpHandleAdapter implements HandleAdapter{
    @Override
    public boolean supports(Object handler) {
        return handler instanceof HttpController;
    }

    @Override
    public void handle(Object handler) {
        ((HttpController)handler).doHttpHandler();
    }
}

class SimpleHandleAdapter implements HandleAdapter{
    @Override
    public boolean supports(Object handler) {
        return handler instanceof SimpleController;
    }

    @Override
    public void handle(Object handler) {
        ((SimpleController)handler).doSimpleHandler();
    }
}

class AnnotationHandleAdapter implements HandleAdapter{
    @Override
    public boolean supports(Object handler) {
        return handler instanceof AnnotationController;
    }

    @Override
    public void handle(Object handler) {
        ((AnnotationController)handler).doAnnotationHandler();
    }
}
