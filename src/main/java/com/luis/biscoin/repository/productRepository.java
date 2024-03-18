package com.luis.biscoin.repository;

import com.luis.biscoin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.prefs.PreferenceChangeEvent;

public interface productRepository extends JpaRepository<Product, Long> {
}
