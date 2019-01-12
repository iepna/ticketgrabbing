package com.tp.springbootjpa.service;

import com.tp.springbootjpa.pojo.Ticket;

public interface TicketService {
    Ticket findById(Integer id);
    Ticket reduceCount(Integer id);
}
