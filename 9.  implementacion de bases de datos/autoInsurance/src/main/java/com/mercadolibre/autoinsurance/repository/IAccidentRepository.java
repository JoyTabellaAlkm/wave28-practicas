package com.mercadolibre.autoinsurance.repository;

import com.mercadolibre.autoinsurance.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccidentRepository extends JpaRepository<Accident, Long> {
}
