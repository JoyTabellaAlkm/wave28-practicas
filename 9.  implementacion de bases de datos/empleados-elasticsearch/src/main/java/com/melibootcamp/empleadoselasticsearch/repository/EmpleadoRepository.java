package com.melibootcamp.empleadoselasticsearch.repository;

import com.melibootcamp.empleadoselasticsearch.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}
