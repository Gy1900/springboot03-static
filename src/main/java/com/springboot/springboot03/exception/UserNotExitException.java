package com.springboot.springboot03.exception;

import org.springframework.stereotype.Component;
/**
 * Created by gy on 2019/6/11 0011 15:06
 */
@Component
public class UserNotExitException extends RuntimeException {
    public UserNotExitException() {
        super("用户不存在");
    }


}
