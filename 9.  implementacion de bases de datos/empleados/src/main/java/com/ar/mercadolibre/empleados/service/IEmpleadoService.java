package com.ar.mercadolibre.empleados.service;

import com.ar.mercadolibre.empleados.dto.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoService {
    EmpleadoDTO crear(EmpleadoDTO empleadoDTO);
    EmpleadoDTO modificar(String id, EmpleadoDTO empleadoDTO);
    List<EmpleadoDTO> traerTodos();
}
