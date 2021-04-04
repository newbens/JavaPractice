package com.niuben.springboot01helloword.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController  //代替@ResponseBody和@Controller
public class HelloController {

    @Value("${person.name}")
    private String name;

    @GeMapping("/hello")
    public String Hello() {
        return "Hello "+name;
    }
}
