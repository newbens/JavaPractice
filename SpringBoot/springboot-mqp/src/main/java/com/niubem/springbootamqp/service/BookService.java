package com.niubem.springbootamqp.service;

import com.niubem.springbootamqp.domian.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    //监听要起到作用，就要开启注解支持
    @RabbitListener(queues = "niuben")
    public void receive(Book book) {
        System.out.println("niuben队列收到消息"+book);
    }
}
