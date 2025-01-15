package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClothingRepository extends JpaRepository<Clothing, Long> {

    // Traer todas las prendas de un determinado talle
    public List<Clothing> findBySizeIgnoreCase(String size);

    // Traer todas las prendas que contengan un determinado nombre
    public List<Clothing> findByNameContainingIgnoreCase(String name);

}
