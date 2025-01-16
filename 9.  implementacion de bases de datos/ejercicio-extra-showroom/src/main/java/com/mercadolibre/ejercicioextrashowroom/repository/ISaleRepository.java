package com.mercadolibre.ejercicioextrashowroom.repository;

import com.mercadolibre.ejercicioextrashowroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {

    @Query("FROM Sale s WHERE s.date = :date")
    List<Sale> findSalesByDate(LocalDate date);

}
