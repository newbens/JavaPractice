package com.niuben.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 */
@Controller
public class HelloController {
    @RequestMapping("hello")
    public String sayHello() {
        System.out.println("hello SpringMVC");
        return "success";
    }
}
