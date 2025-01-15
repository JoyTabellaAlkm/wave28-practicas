package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISaleRepository extends JpaRepository<Sale,Long> {

    @Query("SELECT s FROM Sale s WHERE s.number = :number")
    Sale findSaleByNumber(@Param("number") Integer number);
}
