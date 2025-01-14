package com.melibootcamp.empresadeseguros.service;


import com.melibootcamp.empresadeseguros.dto.MarcaMatriculaModeloDTO;
import com.melibootcamp.empresadeseguros.dto.VehiculoInfoDTO;
import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import com.melibootcamp.empresadeseguros.repository.VehiculoRepository;
import com.melibootcamp.empresadeseguros.service.interfaces.IVehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }


    @Override
    public List<Vehiculo> getVehiculos() {
        List<Vehiculo> toReturn = vehiculoRepository.findAll();
        return toReturn;
    }

    @Override
    public boolean saveVehiculo(Vehiculo Vehiculo) {
        try{
            vehiculoRepository.save(Vehiculo);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Vehiculo getVehiculoById(long id) {
        Vehiculo toReturn = vehiculoRepository.findById(id).orElse(null);
        return toReturn;
    }

    @Override
    public List<String> getPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<VehiculoInfoDTO> getPatenteAndMarca() {
        return vehiculoRepository.findPatenteAndVehiculoOrderAnioFabricacion();
    }

    @Override
    public List<MarcaMatriculaModeloDTO> getVehiculosConPerdidaMayorA10000() {
        return vehiculoRepository.findAllMarcaMatriculaModeloWherePerdidaMayorA10000();
    }

    @Override
    public List<String> findPatentesWhereMasDe4RuedasAndFabricadosEsteAño() {
        return vehiculoRepository.findPatentesWhereMasDe4RuedasAndFabricadosEsteAño();
    }


}
