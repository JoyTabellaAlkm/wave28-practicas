package com.example.api_joyas.repository;

import com.example.api_joyas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya,Long> {
}
