package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.entity.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClotheRepository extends JpaRepository<Clothe, Long> {
    @Query("SELECT c FROM Clothe c WHERE c.codigo = :code ")
    Clothe findClotheByCode(@Param("code") String code);

    @Query("SELECT c FROM Clothe c WHERE c.talle = :size ")
    List<Clothe> findClotheBySize(@Param("size") Float size);

    @Query("SELECT c FROM Clothe c WHERE c.nombre like %:name% ")
    List<Clothe> findClotheByName(@Param("name") String name);
}
