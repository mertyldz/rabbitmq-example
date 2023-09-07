package com.example.contactproducer.integrations;

import com.example.contactproducer.db.entity.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQProducer {
    private final String queueName = "contact";
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Async
    public void sendMessage(Contact contact) {
        try {
            String json = new ObjectMapper().writeValueAsString(contact);
            rabbitTemplate.convertAndSend(queueName, json);
            //log.info("Message sent: " + message);
        } catch (Exception e) {

            log.error("Message not sent: " + e.getMessage());
        }
    }


}
