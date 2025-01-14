package com.melibootcamp.empresadeseguros.service;


import com.melibootcamp.empresadeseguros.entity.Siniestro;
import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import com.melibootcamp.empresadeseguros.repository.SiniestroRepository;
import com.melibootcamp.empresadeseguros.repository.VehiculoRepository;
import com.melibootcamp.empresadeseguros.service.interfaces.ISiniestroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroServiceImpl implements ISiniestroService {

    private final SiniestroRepository siniestroRepository;
    private final VehiculoRepository vehiculoRepository;

    public SiniestroServiceImpl(SiniestroRepository siniestroRepository, VehiculoRepository vehiculoRepository){
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Siniestro> getSiniestros() {
        List<Siniestro> toReturn = siniestroRepository.findAll();
        return toReturn;
    }

    @Override
    public boolean saveSiniestro(Siniestro siniestro) {
          Vehiculo test = vehiculoRepository.findById(siniestro.getVehiculoAsignado().getId()).orElse(null);
            System.out.println("NOMBRE TEST VEHICLE: " + test.getMarca() + test.getModelo());
            if (test != null) {
                siniestro.setVehiculoAsignado(test);
                siniestroRepository.save(siniestro);
                return true;
            } return false;

    }


    /*

Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
            .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        Siniestro siniestro = new Siniestro();
        siniestro.setFecha(fecha);
        siniestro.setPerdidaEconomica(perdidaEconomica);
        siniestro.setVehiculo(vehiculo);  // Aquí asociamos el Vehiculo al Siniestro

        // Guardamos el siniestro, que también guardará el vehículo si es necesario
        return siniestroRepository.save(siniestro)

     */
    @Override
    public Siniestro getSiniestroById(long id) {
        Siniestro toReturn = siniestroRepository.findById(id).orElse(null);
        return toReturn;
    }

/*
    @Override
    public boolean deleteSiniestro(long id) {
        try{
            siniestroRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }



    @Override
    public boolean updateSiniestro(long id, Siniestro siniestro) {

        if (!siniestroRepository.existsById(id)){
            return false;
        }

        siniestro.setId_case(id);

        siniestroRepository.save(siniestro);
        return true;
    }

     */

}
