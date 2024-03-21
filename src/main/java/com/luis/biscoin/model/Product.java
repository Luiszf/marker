package com.luis.biscoin.model;

import jakarta.persistence.*;
import lombok.Data;
import com.luis.biscoin.model.Quantity;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long productId;

    private String title;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="product")
    private List<Quantity> quantities;
}

