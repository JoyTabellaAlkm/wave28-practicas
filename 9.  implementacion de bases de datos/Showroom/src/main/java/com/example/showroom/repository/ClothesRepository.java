package com.example.showroom.repository;

import com.example.showroom.dto.request.ClothesDTO;
import com.example.showroom.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {

    @Query("SELECT c FROM Clothes c WHERE c.talle = :size")
    List<Clothes> findAllBySize(@Param("size") String size);

    @Query("SELECT c FROM Clothes c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :word, '%'))")
    List<Clothes> findAllByNameContaining(@Param("word") String word);}
