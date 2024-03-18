package com.luis.biscoin.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long productId;

    private String title;

}

