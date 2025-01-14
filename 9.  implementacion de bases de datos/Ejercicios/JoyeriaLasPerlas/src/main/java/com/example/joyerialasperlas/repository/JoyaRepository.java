package com.example.joyerialasperlas.repository;

import com.example.joyerialasperlas.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya,Long> {
}
