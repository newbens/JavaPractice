package com.niuben.springbootrestfulcrud.controller;

import com.niuben.springbootrestfulcrud.exception.UserNotFindException;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExcaptionHandler {
//  不是自适应效果
//    @ResponseBody
//    @ExceptionHandler(UserNotFindException.class)//处理异常注解
//    public Map<String, Object> handleExcaption(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notFind");
//        map.put("message", e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotFindException.class)//处理异常注解
    public String handleExcaption(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("code", "user.notFind");
        map.put("message", "出错啦！！！！！");
        //存入request域中，转发到自己定义的错误信息属性中
        request.setAttribute("extend",map);
        //转发
            return "forward:/error";
    }



}
