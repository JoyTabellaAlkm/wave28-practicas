package com.bootcamp.ejerciciojoyeria.repository;

import com.bootcamp.ejerciciojoyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
}
