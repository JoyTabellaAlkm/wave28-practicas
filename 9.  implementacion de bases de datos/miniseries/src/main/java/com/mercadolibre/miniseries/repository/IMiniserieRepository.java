package com.mercadolibre.miniseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.miniseries.entity.Miniserie;

public interface IMiniserieRepository extends JpaRepository<Miniserie, Long> {

}
