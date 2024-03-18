package com.luis.biscoin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quantities")
public class Quantities {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long quantityId;
    private int quantity;

    @ManyToOne
    private Product product;
    private int price;
}
