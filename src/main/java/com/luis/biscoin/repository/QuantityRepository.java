package com.luis.biscoin.repository;

import com.luis.biscoin.model.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityRepository extends JpaRepository<Quantity, Long> {

}
