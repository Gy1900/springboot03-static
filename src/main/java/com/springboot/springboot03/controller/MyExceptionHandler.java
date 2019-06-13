package com.springboot.springboot03.controller;

import com.springboot.springboot03.exception.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gy on 2019/6/11 0011 15:10
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     *定制自己的状态码
     */


    //@ResponseBody-加上就直接返回json
    @ExceptionHandler(UserNotExitException.class)//处理异常的类型
    public String handleException(Exception e,HttpServletRequest request){
        request.setAttribute("java.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<>();

        map.put("code","user.notexist");
        map.put("message",e.getMessage());

        request.setAttribute("ext",map);

        return "forward:/error";
    }
}
