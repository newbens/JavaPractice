package com.niuben.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

    @Autowired
    RestTemplate template;

    @GetMapping("/buy")
    public String buy(String name) {
        String s = template.getForObject("http://PROVIDER/ticket", String.class);
        return name+"购买了"+s;
    }
}
