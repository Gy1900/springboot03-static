package com.springboot.springboot03.config;

import com.springboot.springboot03.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
//        /**会覆盖下面的获取静态资源 /static
//        registry.addViewController("/**").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
        // registry.addViewController("/emps").setViewName("emp/list");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index", "/", "/user/login", "/asserts/**", "/webjars/**", "/emp/**", "/modify");
    }
}
