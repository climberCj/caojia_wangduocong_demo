/**
 * Copyright (c) 2019, 万维公司 All rights reserved.
 * 万维公司 专有/保密源代码,未经许可禁止任何人通过任何渠道使用、修改源代码.
 */
package com.caojiawangduocongdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author caojia
 * @createtime 2019-11-04 17:17
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations("/static/**").
                addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
