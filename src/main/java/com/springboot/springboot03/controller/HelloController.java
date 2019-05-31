package com.springboot.springboot03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public static String sayHello(){
        return "hello";
    }

    @RequestMapping("/abc")
    public static String sayGo(Map<String,Object> maps){
        maps.put("hello","gy");
        maps.put("user",Arrays.asList("张三","李四"));
        return "abc";
    }

//    @RequestMapping("/")
//    public static String startPage(){
//        return "index";
//    }
}
