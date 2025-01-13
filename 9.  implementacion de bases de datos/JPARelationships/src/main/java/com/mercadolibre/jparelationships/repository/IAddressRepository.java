package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.oneToOne.unidirectional.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
