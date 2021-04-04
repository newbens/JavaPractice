package com.niuben.ticket.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component
@Service //将服务发布
public class TicketServiceImp implements TicketService {

    @Override
    public String getTicket() {
        return "<上海大炮>";
    }
}
