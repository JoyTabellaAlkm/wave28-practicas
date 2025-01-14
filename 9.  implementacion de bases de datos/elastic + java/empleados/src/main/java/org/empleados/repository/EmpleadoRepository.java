package org.empleados.repository;

import org.empleados.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}
