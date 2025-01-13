package com.bootcamp.joyerialasperlas.repository;

import com.bootcamp.joyerialasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJoyeriaRepository extends JpaRepository<Joya, Long> {
}