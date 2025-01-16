package com.mercadolibre.elasticsearch.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.elasticsearch.dto.CreateEmpleadoDto;
import com.mercadolibre.elasticsearch.entity.Empleado;
import com.mercadolibre.elasticsearch.repository.IEmpleadoRepository;
import com.mercadolibre.elasticsearch.service.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Empleado save(CreateEmpleadoDto empleado) {
        return empleadoRepository.save(modelMapper.map(empleado, Empleado.class));
    }

    @Override
    public Iterable<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

}
