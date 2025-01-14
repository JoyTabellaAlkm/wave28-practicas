package org.vehiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vehiculos.entity.Vehiculo;
import org.vehiculos.repository.iVehiculoRepository;

import java.util.List;

@Service
public class vehiculoService implements iVehiculoService{

    @Autowired
    private iVehiculoRepository vehiculoRepo;

    @Override
    public List<Vehiculo> findAll() { return vehiculoRepo.findAll(); }

    @Override
    public List<Object[]> findMarcaPatente() { return vehiculoRepo.findAllMarcaPatente() ;}

    @Override
    public List<String> findAllRuedasMayorACuatro() { return vehiculoRepo.findAllMasCuatroRuedas(); }

    @Override
    public List<Object[]> findAllVehiculosSiniestros() { return vehiculoRepo.findAllVehiculosSiniestros(); }

    @Override
    public List<Object[]> findAllSiniestroPerdidaTotal() { return vehiculoRepo.findAllSiniestroPerdidaTotal(); }

}
