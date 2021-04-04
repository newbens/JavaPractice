package com.niuben.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/intercepter")
public class ControllerTest {
    @RequestMapping("test")
    public String test() {
        System.out.println("test");
        return "success";
    }

}
