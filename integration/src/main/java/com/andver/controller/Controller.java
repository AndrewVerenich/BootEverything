package com.andver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    @Qualifier("helloChannel1")
    private MessageChannel messageChannel;

    @GetMapping("/sendMessage")
//    @InboundChannelAdapter(channel = "helloChannel1", poller = @Poller(fixedDelay = "1000"))
    public boolean sendMessage() {
//        return "+++++++";
        return messageChannel.send(MessageBuilder.withPayload("+++++++").build());
    }
}
