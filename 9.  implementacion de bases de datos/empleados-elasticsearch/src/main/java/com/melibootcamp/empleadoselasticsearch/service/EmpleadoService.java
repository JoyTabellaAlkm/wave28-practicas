package com.melibootcamp.empleadoselasticsearch.service;

import com.melibootcamp.empleadoselasticsearch.dto.MessageDto;
import com.melibootcamp.empleadoselasticsearch.entity.Empleado;
import com.melibootcamp.empleadoselasticsearch.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService implements IEmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado empleado) {
        empleado.setId(UUID.randomUUID().toString());
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> toReturn = StreamSupport.stream(empleadoRepository.findAll().spliterator(), false).toList();
        return toReturn;
    }

    @Override
    public Empleado findById(String id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public MessageDto delete(String id) {
        empleadoRepository.deleteById(id);
        return new MessageDto("Empleado eliminado con exito!");
    }

    @Override
    public MessageDto update(Empleado empleado, String id) {
        if(empleadoRepository.existsById(id)){
            empleado.setId(id);
            empleadoRepository.save(empleado);
            return new MessageDto("Empleado actualizado con exito!");
        }
        return new MessageDto("Empleado no existente...");
    }
}
