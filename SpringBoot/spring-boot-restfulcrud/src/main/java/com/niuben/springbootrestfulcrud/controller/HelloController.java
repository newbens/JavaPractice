package com.niuben.springbootrestfulcrud.controller;

import com.niuben.springbootrestfulcrud.exception.UserNotFindException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (!user.equals("aaa")) {
            throw new UserNotFindException();
        }
        return "hello";
    }
    //首先要导入thymeleaf
    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello", "<h1>你好<h1>");//默认放在请求域中
        map.put("users", Arrays.asList("A", "B", "C"));
        return "success";
    }

    @RequestMapping({"/", "/login.html"})
    public String index() {
        return "login";
    }
}
