package com.niuben.springboottask.controller;

import com.niuben.springboottask.service.AsycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsycController {
    @Autowired
    AsycService service;

    @GetMapping("/hello")
    public String hello() {
        service.hello();
        return "success";
    }


}
