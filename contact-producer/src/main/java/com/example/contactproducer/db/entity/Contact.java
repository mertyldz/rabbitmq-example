package com.example.contactproducer.db.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surName;
    @Column
    private String phoneNumber;
}
