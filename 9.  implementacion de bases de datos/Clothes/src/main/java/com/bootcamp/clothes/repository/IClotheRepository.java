package com.bootcamp.clothes.repository;

import com.bootcamp.clothes.entity.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IClotheRepository extends JpaRepository<Clothe, String> {
    Clothe findByCode(Long code);

    List<Clothe> findBySize(String size);

    List<Clothe> findByNameContainingIgnoreCase(String name);

    Set<Clothe> findAllByCodeIn(List<Long> clothesIds);
}
