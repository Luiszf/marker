package com.luis.biscoin.repository;

import com.luis.biscoin.model.Quantities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface quantitiesRepository extends JpaRepository<Quantities, Long> {

}
