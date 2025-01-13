package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.oneToMany.bidirectional.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {
}
