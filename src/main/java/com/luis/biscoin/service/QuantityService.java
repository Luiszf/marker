package com.luis.biscoin.service;

import com.luis.biscoin.model.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import com.luis.biscoin.repository.QuantityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuantityService {

    @Autowired
    QuantityRepository repository;

    public Quantity save(Quantity quantity){
        return repository.save(quantity);
    }

    public Optional<Quantity> findQuantityById(Long id){
        return repository.findById(id);
    }
}
