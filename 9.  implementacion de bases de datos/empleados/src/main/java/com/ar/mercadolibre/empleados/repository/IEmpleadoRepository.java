package com.ar.mercadolibre.empleados.repository;

import com.ar.mercadolibre.empleados.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}
