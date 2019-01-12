package com.tp.springbootjpa.pojo;

import java.io.Serializable;

public class Message implements Serializable {
    private Integer ticketId;
    private Integer userId;
    public Message(){

    }

    public Message(Integer ticketId, Integer userId) {
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
