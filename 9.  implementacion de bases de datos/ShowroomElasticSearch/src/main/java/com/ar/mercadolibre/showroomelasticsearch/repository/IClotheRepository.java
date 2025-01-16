package com.ar.mercadolibre.showroom.repository;


import com.ar.mercadolibre.showroom.entity.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClotheRepository extends JpaRepository<Clothe, Long> {
    List<Clothe> findByNombreContainingIgnoreCase(String name);
    List<Clothe> findByTalla(String size);
}
