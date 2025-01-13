package com.joyeria.repository;

import com.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJoyeriaRepository extends JpaRepository<Joya, Integer> {
}
