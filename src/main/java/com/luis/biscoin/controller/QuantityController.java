package com.luis.biscoin.controller;

import com.luis.biscoin.model.Quantity;
import com.luis.biscoin.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/quantity")
public class QuantityController {

    @Autowired
    QuantityService service;

    @PostMapping
    ResponseEntity<Quantity> saveQuantity(@RequestBody Quantity quantity){
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(quantity));
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Quantity>> getQuantityById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findQuantityById(id));
    }
}
