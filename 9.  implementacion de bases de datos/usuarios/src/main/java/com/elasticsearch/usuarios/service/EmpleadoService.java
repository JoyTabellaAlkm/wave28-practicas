package com.elasticsearch.usuarios.service;

import com.elasticsearch.usuarios.model.Empleado;
import com.elasticsearch.usuarios.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public void crearEmpleado(Empleado e) {
        empleadoRepository.save(e);
    }

    public List<Empleado> getAllEmpleados() {
        var empleados = new ArrayList<Empleado>();
        empleadoRepository.findAll().forEach(empleados::add);
        return empleados;
    }
}
