package com.example.contactproducer.contoller;

import com.example.contactproducer.db.entity.Contact;
import com.example.contactproducer.integrations.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RabbitMQProducerController {
    @Autowired
    RabbitMQProducer rabbitMQProducer;

    @PostMapping
    public ResponseEntity<Boolean> sendMessage(@RequestBody Contact contact) {
        rabbitMQProducer.sendMessage(contact);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
