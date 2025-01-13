package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.oneToMany.bidirectional.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
}
