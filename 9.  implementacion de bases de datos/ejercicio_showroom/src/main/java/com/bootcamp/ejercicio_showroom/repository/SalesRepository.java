package com.bootcamp.ejercicio_showroom.repository;

import com.bootcamp.ejercicio_showroom.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findByDate(LocalDate date);
}
