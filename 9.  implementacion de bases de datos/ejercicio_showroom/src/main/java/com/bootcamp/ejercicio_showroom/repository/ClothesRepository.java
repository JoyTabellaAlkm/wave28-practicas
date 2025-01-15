package com.bootcamp.ejercicio_showroom.repository;

import com.bootcamp.ejercicio_showroom.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {
    List<Clothes> findByNameContainingIgnoreCase(String name);
    Optional<Clothes> findByCode(String code);
    Optional<Clothes> deleteByCode(String code);
    List<Clothes> findBySize(String size);
}
