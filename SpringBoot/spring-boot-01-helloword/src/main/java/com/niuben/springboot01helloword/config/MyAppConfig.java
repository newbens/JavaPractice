package com.niuben.springboot01helloword.config;


import com.niuben.springboot01helloword.service.HelloService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Configuration指明当前类是配置类
 */
@Configuration
public class MyAppConfig {

    @Bean//将方法的返回值返回到容器中，组件默认id为方法名
    public HelloService helloService() {
        System.out.println("@Bean生效了");
        return new HelloService();
    }

}
