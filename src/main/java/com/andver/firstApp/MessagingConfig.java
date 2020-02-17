package com.andver.firstApp;

import com.andver.firstApp.messaging.PersonHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    private Logger logger = LoggerFactory.getLogger(MessagingConfig.class);

    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }

    @RabbitListener(queues = "myQueue")
    public void listen(String in) {
        logger.info("Message read from myQueue : " + in);
    }


    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container =
                new SimpleMessageListenerContainer(connectionFactory);
        MessageListenerAdapter adapter = new MessageListenerAdapter(personHandler());
        container.setMessageListener(adapter);
        container.setQueues(myQueue());
        return container;
    }

    @Bean
    public PersonHandler personHandler() {
        return new PersonHandler();
    }
}
