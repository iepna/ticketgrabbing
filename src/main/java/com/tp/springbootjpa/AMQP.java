package com.tp.springbootjpa;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

@SpringBootApplication
@EntityScan("com.tp.springbootjpa.pojo")
@EnableRabbit
@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class AMQP {
    public static void main(String[] args){
        SpringApplication.run(AMQP.class,args);
    }
}
