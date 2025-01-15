package com.example.empleados.repository;

import com.example.empleados.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    List<Empleado> findByNombre(String nombre);
}
