package com.tp.springbootjpa.controller;

import com.tp.springbootjpa.mq.MQSender;
import com.tp.springbootjpa.pojo.Message;
import com.tp.springbootjpa.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tp.springbootjpa.pojo.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private MQSender mqSender;

    @RequestMapping("/get/{id}")
    public Ticket getByid(@PathVariable Integer id){
        return ticketService.findById(id);
    }

    @RequestMapping("/reduce/{id}/{userId}")
    public String reduceCount(@PathVariable Integer id, @PathVariable Integer userId){
        Message message = new Message(id,userId);

        ticketService.reduceCount(id);
        mqSender.sendMessage(new Message(message.getTicketId(), message.getUserId()));

        return "抢票成功!";
    }

}
