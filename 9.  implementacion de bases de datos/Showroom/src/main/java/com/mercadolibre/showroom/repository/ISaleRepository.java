package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT v FROM Sale v WHERE v.date = :date")
    List<Sale> findByDate(LocalDate date);

}
