package com.example.rehber.contoller;

import com.example.rehber.database.entity.Contact;
import com.example.rehber.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.createContact(contact), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getContacts() {
        return new ResponseEntity<>(contactService.getAll(), HttpStatus.OK);
    }

}
