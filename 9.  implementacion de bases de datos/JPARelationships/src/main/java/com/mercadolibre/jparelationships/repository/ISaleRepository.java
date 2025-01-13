package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.oneToMany.unidirectional.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
}
