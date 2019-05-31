package com.springboot.springboot03.config;

import com.springboot.springboot03.component.LoginHandlerInterceptor;
import com.springboot.springboot03.component.LoginLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gy
 * extends WebMvcConfigurationSupport
 * //    设置视图，由于国际化切换，local设置locale = new Locale(split[0],split[1]);、
 * //    所以，如果只有一个/的视图可以转换为index（ registry.addViewController("/").setViewName("index");）
 * // 则url改变就没有视图可以对应了404了
 * //    所以 registry.addViewController("/**").setViewName("index");
 * //    /**很重要
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/**").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
    /**
     * 国际化设置
     * 变成bean加入容器中，会随着WebMvcConfigurer，一起载入
     */

    @Bean
    public org.springframework.web.servlet.LocaleResolver localeResolver(){
        return new LoginLocaleResolver();
    }

    /**
     * 增加拦截器，拦截未登录就像进入的页面，放过一些页面。内部转发去index视图
     */

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/","/user/login","/asserts/**","/webjars/**");
    }*/

/**
     * 启示界面
     * 所有的WebMvcConfigurerAdapter组件都会一起起作用
     *
     * 使用 WebMvcConfigurationSupport 而静态文件不显示CSS样式的，这是因为替换之后之前的静态资源文件 会被拦截，导致无法可用。
     * 解决办法：重写 addResourceHandlers（）方法，加入静态文件路径即可
     */

//    @Bean //将组件注册在容器
//    public WebMvcConfigurationSupport myWebMvcConfigurationSupport() {
//        WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport() {
//            @Override
//            protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/**").addResourceLocations("classpath:/**/");
//            }
//
//            @Override
//            protected void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//            }
//        };
//        return webMvcConfigurationSupport;
//    }
}


