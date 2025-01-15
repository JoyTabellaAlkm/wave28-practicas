package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ISaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT v FROM Sale v WHERE v.date = :date")
    List<Sale> findByDate(LocalDate date);

    @Query("SELECT DISTINCT s FROM Sale s " +
            "LEFT JOIN FETCH s.saleClothings sc " +
            "LEFT JOIN FETCH sc.clothing")
    List<Sale> findAllWithClothings();

    @Query("SELECT s FROM Sale s " +
            "LEFT JOIN FETCH s.saleClothings sc " +
            "LEFT JOIN FETCH sc.clothing " +
            "WHERE s.number = :number")
    Optional<Sale> findByNumberWithClothings(@Param("number") Long number);

}
