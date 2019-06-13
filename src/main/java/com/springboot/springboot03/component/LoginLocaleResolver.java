package com.springboot.springboot03.component;

import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by gy on 2019/5/30 0030 15:47
 *
 * @author Administrator
 * 国际化判断，根据表头的区域信息，index.html中设置的参数，request.getParameter("l");
 */

public class LoginLocaleResolver implements org.springframework.web.servlet.LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

   /* @Bean
    public LoginLocaleResolver localeResolver(){
        return new LoginLocaleResolver();
    }*/


}
