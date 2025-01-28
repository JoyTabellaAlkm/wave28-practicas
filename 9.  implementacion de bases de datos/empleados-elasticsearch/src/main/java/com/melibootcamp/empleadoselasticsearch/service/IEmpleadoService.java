package com.melibootcamp.empleadoselasticsearch.service;

import com.melibootcamp.empleadoselasticsearch.dto.MessageDto;
import com.melibootcamp.empleadoselasticsearch.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
    public Empleado save (Empleado empleado);

    public List<Empleado> findAll();

    public Empleado findById(String id);

    public MessageDto delete (String id);

    public MessageDto update (Empleado empleado, String id);
}
