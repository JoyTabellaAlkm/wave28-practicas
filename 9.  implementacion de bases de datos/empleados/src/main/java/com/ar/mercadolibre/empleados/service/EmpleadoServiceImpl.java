package com.ar.mercadolibre.empleados.service;

import com.ar.mercadolibre.empleados.dto.EmpleadoDTO;
import com.ar.mercadolibre.empleados.entity.Empleado;
import com.ar.mercadolibre.empleados.exceptions.NotFoundException;
import com.ar.mercadolibre.empleados.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    private final IEmpleadoRepository empleadoRepository;
    private final ModelMapper mapper;

    public EmpleadoServiceImpl(IEmpleadoRepository empleadoRepository, ModelMapper mapper) {
        this.empleadoRepository = empleadoRepository;
        this.mapper = mapper;
    }

    @Override
    public EmpleadoDTO crear(EmpleadoDTO empleadoDTO) {
        Empleado empleadoAGuardar = mapper.map(empleadoDTO, Empleado.class);
        Empleado empleadoGuardado = empleadoRepository.save(empleadoAGuardar);

        return mapper.map(empleadoGuardado, EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO modificar(String id, EmpleadoDTO empleadoDTO) {
        validarEmpleaadoId(id);
        empleadoDTO.setId(id);
        Empleado empleadoAModificar = mapper.map(empleadoDTO, Empleado.class);
        Empleado empleadoModificado = empleadoRepository.save(empleadoAModificar);

        return mapper.map(empleadoModificado, EmpleadoDTO.class);
    }

    @Override
    public List<EmpleadoDTO> traerTodos() {
        Iterable<Empleado> empleados = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadoDTOs = new ArrayList<>();

        for(Empleado empleado: empleados) {
            empleadoDTOs.add(mapper.map(empleado, EmpleadoDTO.class));
        }

        return empleadoDTOs;
    }

    private Empleado validarEmpleaadoId(String id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if (empleado.isEmpty()) {
            throw new NotFoundException("Empleado no encontrado");
        }

        return empleado.get();
    }
}
