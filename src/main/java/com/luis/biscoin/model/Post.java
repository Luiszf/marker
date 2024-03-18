package com.luis.biscoin.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long postId;


    private String title;

    @Lob
    private byte[] image;

    private Date date;


    @OneToOne
    private Product product;
}
