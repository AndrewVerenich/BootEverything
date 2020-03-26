package com.andver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class SomeService {

    private Logger logger = LoggerFactory.getLogger(SomeService.class);

    @ServiceActivator(inputChannel = "helloChannel1", outputChannel = "helloChannel2")
    public String printHelloMessage(String message) {
        logger.info("Message from first service activator: " + message);
        return "---------";
    }

    @ServiceActivator(inputChannel = "helloChannel1")
    public void printHelloMessage1(String message) {
        logger.info("Message from first service activator: " + message);
    }

    @ServiceActivator(inputChannel = "helloChannel2")
    public void printHelloMessage2(Message<String> message, @Header String id, @Header Long timestamp) {
        logger.info("Message from second service activator: " + message.getPayload() + id + timestamp + "  " + message.getHeaders());
    }

}
