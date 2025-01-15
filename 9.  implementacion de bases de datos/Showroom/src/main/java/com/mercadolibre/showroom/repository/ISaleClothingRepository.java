package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.SaleClothing;
import com.mercadolibre.showroom.model.SaleClothingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISaleClothingRepository extends JpaRepository<SaleClothing, SaleClothingId> {

    @Query("SELECT sc FROM SaleClothing sc WHERE sc.sale.number = :saleNumber")
    List<SaleClothing> findBySaleNumber(Long saleNumber);
}
