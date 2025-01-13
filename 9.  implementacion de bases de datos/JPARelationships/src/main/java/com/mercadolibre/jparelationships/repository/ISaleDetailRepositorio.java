package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.oneToMany.unidirectional.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleDetailRepositorio extends JpaRepository<SaleDetail, Long> {
}
