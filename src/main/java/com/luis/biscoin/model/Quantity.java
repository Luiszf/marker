package com.luis.biscoin.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "quantities")
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long quantityId;

    private int quantity;

    @ManyToOne
    private Product product;

    private int price;
}
