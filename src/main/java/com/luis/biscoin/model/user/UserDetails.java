package com.luis.biscoin.model.user;

import com.luis.biscoin.model.ImageData;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class UserDetails {

    ImageData image;

    String username;

    String phoneNumber;

    String Address;

    Float lat;

    Float lng;
}