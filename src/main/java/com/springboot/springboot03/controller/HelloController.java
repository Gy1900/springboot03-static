package com.springboot.springboot03.controller;

import com.springboot.springboot03.exception.UserNotExitException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(@RequestParam("user") String user){
        if (user.equals("aaa")) {
            throw  new UserNotExitException();
        }
        return "hello";
    }

    @RequestMapping("/abc")
    public String sayGo(Map<String, Object> maps) {
        maps.put("hello", "gy");
        maps.put("user", Arrays.asList("张三", "李四"));
        return "abc";
    }

//    @RequestMapping("/")
//    public static String startPage(){
//        return "index";
//    }
}
