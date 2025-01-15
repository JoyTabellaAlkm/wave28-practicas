package com.ejercicios.ejercicioproductos.repository;

import com.ejercicios.ejercicioproductos.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Producto, Long> {
    
}
