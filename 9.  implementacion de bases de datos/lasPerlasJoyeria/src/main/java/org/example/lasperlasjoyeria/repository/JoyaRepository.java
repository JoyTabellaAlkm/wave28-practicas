package org.example.lasperlasjoyeria.repository;

import org.example.lasperlasjoyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Long> {
}
