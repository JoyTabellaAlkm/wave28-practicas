package com.mercadolibre.clavecompuesta.repository;

import com.mercadolibre.clavecompuesta.model.Compra;
import com.mercadolibre.clavecompuesta.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {
}
