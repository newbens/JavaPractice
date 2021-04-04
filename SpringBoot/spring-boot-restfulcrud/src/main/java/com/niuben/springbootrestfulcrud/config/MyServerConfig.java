package com.niuben.springbootrestfulcrud.config;


import com.niuben.springbootrestfulcrud.servlet.Myservlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServerConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servlet = new ServletRegistrationBean(new Myservlet(),"/myservlet");
        return servlet;
    }
}
