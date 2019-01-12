package com.tp.springbootjpa.pojo;

import org.omg.CORBA.INTERNAL;

public class Result {
    private Integer ticketId;
    private Integer userId;

    public Result(Integer ticketId, Integer userId) {
        this.ticketId = ticketId;
        this.userId = userId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
