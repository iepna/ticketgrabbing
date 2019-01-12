package com.tp.springbootjpa.service;

import com.tp.springbootjpa.dao.TicketRepository;
import com.tp.springbootjpa.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket findById(Integer id) {
        return ticketRepository.findTicketById(id);
    }

    public Ticket reduceCount(Integer id) {
        ticketRepository.reduceCount(id);
        return findById(id);
    }
}
