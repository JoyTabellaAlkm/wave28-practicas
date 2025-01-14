package com.example.concesionaria.repository;

import com.example.concesionaria.model.VService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<VService, Long> { }
