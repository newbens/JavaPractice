package com.niuben.provider.controller;

import com.niuben.provider.service.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    Ticket ticket;

    @GetMapping("/ticket")
    public String getTicket() {
        return ticket.get();
    }
}
