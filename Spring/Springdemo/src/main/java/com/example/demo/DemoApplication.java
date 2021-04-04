package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication说明这是一个SpringBoot应用
 */
 @SpringBootApplication//主配置类
public class DemoApplication {

    public static void main(String[] args) {
        //启动应用
        SpringApplication.run(DemoApplication.class, args);
    }

}
