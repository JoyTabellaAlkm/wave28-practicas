package org.empleados.service;

import org.empleados.domain.Empleado;
import org.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadosService {

    @Autowired
    private EmpleadoRepository repo;

    public Empleado add(Empleado e){
        repo.save(e);
        return e;
    }

    public Empleado edit(Empleado e){
        String id = e.getId();
        Optional<Empleado> existente = repo.findById(id);
        if(existente.isPresent()){
            Empleado real = existente.get();
            real.setNombre(e.getNombre());
            real.setApellido(e.getApellido());
            real.setEdad(e.getEdad());
            real.setCiudad(e.getCiudad());
            real.setProvincia(e.getProvincia());
            repo.save(real);
            return real;
        }
        return null;
    }
}
