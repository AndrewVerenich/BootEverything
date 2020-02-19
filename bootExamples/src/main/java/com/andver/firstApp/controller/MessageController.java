package com.andver.firstApp.controller;

import com.andver.firstApp.domain.PersonBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/sendSimpleMessage")
    public void sendSimpleMessage() {
        rabbitTemplate.convertAndSend("myQueue", "Simple Message");
    }

    @GetMapping("/sendPersonMessage")
    public void sendPersonMessage() {
        rabbitTemplate.convertAndSend("myQueue", new PersonBuilder().setName("Andrei").setAge(27).build());
    }

}
