package com.mercadolibre.ejerciciojpajoyas.repository;

import com.mercadolibre.ejerciciojpajoyas.Entity.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewelry, Long> { }