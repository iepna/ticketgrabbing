package com.tp.springbootjpa.mq;

import com.alibaba.fastjson.JSONObject;
import com.tp.springbootjpa.pojo.Message;
import com.tp.springbootjpa.pojo.Result;
import com.tp.springbootjpa.pojo.Ticket;
import com.tp.springbootjpa.service.ResultService;
import com.tp.springbootjpa.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ResultService resultService;

    @RabbitListener(queues = MQContants.QUEUE)
    public void receive(String message){
        JSONObject jsonObject = JSONObject.parseObject(message);
        Message msg = JSONObject.toJavaObject(jsonObject,Message.class);
        Integer ticketId = msg.getTicketId();
        Integer userId = msg.getUserId();

        //减库存
        Ticket ticket = ticketService.reduceCount(ticketId);
        if (ticket.getCount()<=0){
            return;
        }
        //判断是否已经抢过
        Result oneByUserId = resultService.findOneByUserId(ticketId);
        if (oneByUserId!=null){
            return;
        }
        resultService.add(new Result(ticketId,userId));
    }
}
