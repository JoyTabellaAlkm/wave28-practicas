package com.mercadolibre.ejercicioextrashowroom.repository;

import com.mercadolibre.ejercicioextrashowroom.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClothesRepository extends JpaRepository<Clothes, Long> {

    @Query("FROM Clothes c where c.size = :size")
    List<Clothes> findClothesBySize(String size);

    @Query("FROM Clothes c where lower(c.name) LIKE lower(:query)")
    List<Clothes> searchClothesByName(String query);

}
