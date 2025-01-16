package com.example.empleadoselasticsearch.service;

import com.example.empleadoselasticsearch.dto.EmpleadoDto;
import com.example.empleadoselasticsearch.entity.Empleado;
import com.example.empleadoselasticsearch.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    IEmpleadoRepository repository;



    @Override
    public EmpleadoDto createEmpleado(EmpleadoDto empleadoDto) {
        EmpleadoDto empDto = modelMapper.map(repository.save(modelMapper.map(empleadoDto, Empleado.class)), EmpleadoDto.class);
        return empDto;
    }

    @Override
    public List<EmpleadoDto> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).stream().map(e->modelMapper.map(e,EmpleadoDto.class)).toList();
    }
}
