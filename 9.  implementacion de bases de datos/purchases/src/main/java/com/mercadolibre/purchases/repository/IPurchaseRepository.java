package com.mercadolibre.purchases.repository;

import com.mercadolibre.purchases.entity.Purchase;
import com.mercadolibre.purchases.entity.PurchaseKey;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPurchaseRepository extends JpaRepository<Purchase, PurchaseKey> {
}
