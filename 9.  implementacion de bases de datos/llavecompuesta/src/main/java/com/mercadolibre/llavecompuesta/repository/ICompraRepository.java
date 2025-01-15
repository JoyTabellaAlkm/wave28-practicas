package com.mercadolibre.llavecompuesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.llavecompuesta.entity.Compra;

public interface ICompraRepository extends JpaRepository<Compra, Compra.CompraId> {

}
