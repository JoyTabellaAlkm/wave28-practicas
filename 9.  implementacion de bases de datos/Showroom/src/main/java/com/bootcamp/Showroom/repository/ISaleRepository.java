package com.bootcamp.Showroom.repository;

import com.bootcamp.Showroom.entity.Cloth;
import com.bootcamp.Showroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale,Long> {
    Sale findByNumber(Integer number);

    void deleteByNumber(Integer number);

    List<Sale> findSalesByDate(LocalDate date);

    @Query("SELECT c FROM Cloth c JOIN c.sales s WHERE s.number = :number")
    List<Cloth> findClothesBySaleNumber(Integer number);
}
