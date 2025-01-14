package com.mercadolibre.kartsrelaciones.repository;

import com.mercadolibre.kartsrelaciones.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country, Long> {
}
