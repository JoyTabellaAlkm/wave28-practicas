package com.example.ropa_api.repository;

import com.example.ropa_api.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByDate(LocalDate date);
}
