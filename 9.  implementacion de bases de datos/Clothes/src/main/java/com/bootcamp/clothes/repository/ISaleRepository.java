package com.bootcamp.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.clothes.entity.Sale;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByDate(LocalDate date);
}