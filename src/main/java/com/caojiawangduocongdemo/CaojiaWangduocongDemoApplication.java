package com.caojiawangduocongdemo;

import com.caojiawangduocongdemo.intercept.MyIntercept;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@MapperScan("com.caojiawangduocongdemo.dao")
public class CaojiaWangduocongDemoApplication /*extends WebMvcConfigurationSupport*/ {

    public static void main(String[] args) {
        SpringApplication.run(CaojiaWangduocongDemoApplication.class, args);
    }
    /**
     * 自定义拦截器
     * @param registry
     */
    /*@Override
    protected void addInterceptors(InterceptorRegistry registry){
        List<String> excludeAllList = Arrays.asList("/", "/login","/main","/teacher/main","/student/main", "/css/**", "/fonts/**","/images/**","/img/**", "/js/**", "/plugins/**");
        registry.addInterceptor(new MyIntercept()).addPathPatterns("/**").
                excludePathPatterns(excludeAllList);
        super.addInterceptors(registry);
    }*/

    /**
     * 重写该方法访问静态资源
     * @param registry
     */
    /*@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/META-INF/resources/").
                addResourceLocations("classpath:/resources/").
                addResourceLocations("classpath:/static/").
                addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }*/
    /**
     * 自定义默认请求
     * @param registry
     */
    /*@Override
    protected void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        super.addViewControllers(registry);
    }*/
}
