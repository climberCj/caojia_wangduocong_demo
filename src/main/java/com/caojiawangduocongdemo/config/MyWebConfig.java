/**
 * Copyright (c) 2019, 万维公司 All rights reserved.
 * 万维公司 专有/保密源代码,未经许可禁止任何人通过任何渠道使用、修改源代码.
 */
package com.caojiawangduocongdemo.config;

import com.caojiawangduocongdemo.intercept.MyIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author caojia
 * @createtime 2019-11-04 17:17
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurationSupport {
    @Autowired
    private MyIntercept myIntercept;

    /**
     * 重写该方法访问静态资源
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/resources/").
                addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 自定义拦截器
     * @param registry
     */
    protected void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myIntercept).addPathPatterns("/**").
                excludePathPatterns("/","/login");
        super.addInterceptors(registry);
    }

    /**
     * 自定义默认请求
     * @param registry
     */
    protected void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        super.addViewControllers(registry);
    }
}
