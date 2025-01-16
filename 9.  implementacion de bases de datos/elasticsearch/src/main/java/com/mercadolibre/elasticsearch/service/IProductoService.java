package com.mercadolibre.elasticsearch.service;

import com.mercadolibre.elasticsearch.dto.CreateProductoDto;
import com.mercadolibre.elasticsearch.entity.Producto;

public interface IProductoService {

    public Producto save(CreateProductoDto producto);

    public Iterable<Producto> findAll();

}
