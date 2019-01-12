package com.tp.springbootjpa.mq;

import com.alibaba.fastjson.JSONObject;
import com.tp.springbootjpa.pojo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Message message){
        String msg = JSONObject.toJSONString(message);
        amqpTemplate.convertAndSend(MQContants.QUEUE,msg);
    }
}
