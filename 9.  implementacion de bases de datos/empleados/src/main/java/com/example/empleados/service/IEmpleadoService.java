package com.example.empleados.service;

import com.example.empleados.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<Empleado> findByNombre(String nombre);
    Empleado createEmpleado(Empleado empleado);
}
