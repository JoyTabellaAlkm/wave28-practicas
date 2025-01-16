package com.example.empleadoselasticsearch.repository;

import com.example.empleadoselasticsearch.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Long> {
}
