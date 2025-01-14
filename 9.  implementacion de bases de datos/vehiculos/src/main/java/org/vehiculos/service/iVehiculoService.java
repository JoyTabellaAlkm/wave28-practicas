package org.vehiculos.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.vehiculos.entity.Vehiculo;
import org.vehiculos.repository.iVehiculoRepository;

import java.util.List;

public interface iVehiculoService {


    public List<Vehiculo> findAll();

    public List<Object[]> findMarcaPatente();

    public List<String> findAllRuedasMayorACuatro();

    public List<Object[]> findAllVehiculosSiniestros();

    public List<Object[]> findAllSiniestroPerdidaTotal ();
}
