package com.luis.biscoin.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "quantity")
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long quantityId;

    private int productQuantity;

    private int price;

    private int quantity;
}
