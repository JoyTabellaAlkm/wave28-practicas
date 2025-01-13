package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
