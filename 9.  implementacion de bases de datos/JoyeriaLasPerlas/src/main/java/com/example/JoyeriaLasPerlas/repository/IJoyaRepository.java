package com.example.JoyeriaLasPerlas.repository;

import com.example.JoyeriaLasPerlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Integer> {
}
