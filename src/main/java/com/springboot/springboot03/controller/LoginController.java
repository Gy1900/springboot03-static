package com.springboot.springboot03.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by gy on 2019/5/30 0030 18:24
 * <p>
 * 返回String，但是在MymvcConfig中会映射成ModelAndView（addViewControllers：registry.addViewController("/main.html").setViewName("dashboard");）
 */
@Controller
public class LoginController {

    //    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String myController(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登陆成功，F5 防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);
//            重定向
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名密码错误");
            return "index";
        }
    }
}
