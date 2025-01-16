package com.mercadolibre.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mercadolibre.elasticsearch.entity.Empleado;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

}
