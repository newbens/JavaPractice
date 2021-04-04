package com.niuben.consumeruser.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.niuben.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * 映入依赖
 */
@Service
public class UserService {
    @Reference //远程引用
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("“买到票了"+ticket);
    }
}
