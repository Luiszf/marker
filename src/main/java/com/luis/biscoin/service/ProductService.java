package com.luis.biscoin.service;

import com.luis.biscoin.model.Product;
import com.luis.biscoin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Optional<Product> findProductById(long id){
        return repository.findById(id);
    }
    public Product save(Product product){
        return repository.save(product);
    }

    public List<Product> listAllProducts(){
        return repository.findAll();
    }
}
