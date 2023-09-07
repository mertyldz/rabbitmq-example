package com.example.rehber.service;

import com.example.rehber.database.entity.Contact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumerService {
    @Autowired
    ContactService contactService;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) throws JsonProcessingException {
        Contact contact = new ObjectMapper().readValue(message, Contact.class);
        contactService.createContact(contact);
//        log.info(String.format("Received message -> %s", message));
    }
}
