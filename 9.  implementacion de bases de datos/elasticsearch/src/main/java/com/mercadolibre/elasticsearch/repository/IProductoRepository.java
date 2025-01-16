package com.mercadolibre.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mercadolibre.elasticsearch.entity.Producto;

public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {

}
