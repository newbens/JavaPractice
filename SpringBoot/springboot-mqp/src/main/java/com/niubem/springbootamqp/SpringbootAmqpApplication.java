package com.niubem.springbootamqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.自动配置
 *      1.RabbitAutoConfiguration
 *      2.在RabbitAutoConfiguration中自动配置了连接工厂rabbitConnectionFactory
 *      3.RabbitProperties类封装了配置
 *      4.rabbitTemplate:操作rabbitMQ发送和接受
 *      5.amqpAdmin 系统管理功能组件，用来声明队列，创建交换器，等等
 */
@EnableRabbit //开启基于注解的RabbitMQ
@SpringBootApplication
public class SpringbootAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAmqpApplication.class, args);
    }

}
