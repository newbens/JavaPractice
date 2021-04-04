package com.niubem.springbootamqp;

import com.niubem.springbootamqp.domian.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

@SpringBootTest
class SpringbootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test//创建exchange
    public void createExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("ampAddmin.exchange"));
//        System.out.println("创建完成！！！");

        //创建队列
//        amqpAdmin.declareQueue(new Queue("amqAdmin.queue",true));
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("ampAdmin.queue", Binding.DestinationType.QUEUE,"ampAddmin.exchange","amqp.haha",null));

    }

    @Test
    void contextLoads() {
    }

    @Test//单波发送
    public void test() {
//        rabbitTemplate.send(exchange,routeKey,message);
//        rabbitTemplate.convertAndSend(exchang,routeKey,object);  粥熬传入要发送的对象，自动序列化
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloword",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","niuben",new Book("心理罪",108.6));

    }

    @Test//接收消息
    public void test2() {
        Object object = rabbitTemplate.receiveAndConvert("niuben");
        System.out.println(object.getClass());
        System.out.println(object );
    }
}
