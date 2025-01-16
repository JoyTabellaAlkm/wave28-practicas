package com.ar.mercadolibre.showroom.repository;

import com.ar.mercadolibre.showroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByFecha(LocalDate date);

    @Query("SELECT s FROM Sale s JOIN s.listaDePrendas c GROUP BY s HAVING COUNT(c) = :numClothes")
    List<Sale> findSalesByNumberOfClothes(@Param("numClothes") long numClothes);
}
