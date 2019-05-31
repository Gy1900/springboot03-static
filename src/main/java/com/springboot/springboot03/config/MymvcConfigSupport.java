package com.springboot.springboot03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by gy on 2019/5/31 0031 15:03
 */
@Configuration
public class MymvcConfigSupport extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/**").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
}
