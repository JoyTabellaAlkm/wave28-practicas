package com.mercadolibre.elasticsearch.service;

import com.mercadolibre.elasticsearch.dto.CreateEmpleadoDto;
import com.mercadolibre.elasticsearch.entity.Empleado;

public interface IEmpleadoService {

    public Empleado save(CreateEmpleadoDto empleado);

    public Iterable<Empleado> findAll();

}
