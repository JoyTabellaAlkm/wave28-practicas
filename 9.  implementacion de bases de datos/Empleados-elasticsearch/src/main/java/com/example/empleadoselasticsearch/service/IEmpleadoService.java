package com.example.empleadoselasticsearch.service;

import com.example.empleadoselasticsearch.dto.EmpleadoDto;
import com.example.empleadoselasticsearch.entity.Empleado;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmpleadoService {
    EmpleadoDto createEmpleado(EmpleadoDto empleado);

    List<EmpleadoDto> findAll(int page, int size);
}
