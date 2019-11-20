package com.caojiawangduocongdemo.config;

import com.caojiawangduocongdemo.intercept.MyIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author caojia
 * @createtime 2019-11-04 17:17
 */
@Configuration
public class MyWebConfig /*extends WebMvcConfigurationSupport*/ implements WebMvcConfigurer {
    @Autowired
    private MyIntercept myIntercept;

    /**
     * 重写该方法访问静态资源
     * @param registry
     */
    /*@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/resources/").
                addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }*/

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myIntercept).addPathPatterns("/**").
                excludePathPatterns("/","/login","/main","/css/**", "/fonts/**","/images/**","/img/**", "/js/**", "/plugins/**");
        //super.addInterceptors(registry);
    }

    /**
     * 自定义默认请求
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        //super.addViewControllers(registry);
    }
}
