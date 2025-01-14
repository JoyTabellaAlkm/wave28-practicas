package com.melibootcamp.empresadeseguros.service;


import com.melibootcamp.empresadeseguros.dto.MarcaPatenteDTO;
import com.melibootcamp.empresadeseguros.dto.PatenteDTO;
import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import com.melibootcamp.empresadeseguros.repository.VehiculoRepository;
import com.melibootcamp.empresadeseguros.service.interfaces.IVehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
            return false;
        }
    }

    @Override
    public Vehiculo getVehiculoById(long id) {
        Vehiculo toReturn = vehiculoRepository.findById(id).orElse(null);
        return toReturn;
    }

    @Override
    public List<PatenteDTO> getPatentesRegistradas() {
        List<PatenteDTO> patentes = vehiculoRepository.getGovernmentPlateFromRegisteredVehicle()
                .stream()
                .map(PatenteDTO::new)
                .collect(Collectors.toList());
        return patentes;
    }

    @Override
    public List<MarcaPatenteDTO> getMarcaYPatentesEnOrden() {
        List<MarcaPatenteDTO> marcasYPatentes = vehiculoRepository.getGovernmentPlateAndBrandFromRegisteredVehicleInOrder()
                .stream()
                .map(v -> new MarcaPatenteDTO(v.getPatente(),v.getMarca()))
                .toList();
        return marcasYPatentes;
    }

    //---



    /*
    @Override
    public boolean deleteVehiculo(long id) {
        try{
            vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }



    @Override
    public boolean updateVehiculo(long id, Vehiculo vehiculo) {

        if (!vehiculoRepository.existsById(id)){
            return false;
        }

        vehiculo.setId_case(id);

        vehiculoRepository.save(vehiculo);
        return true;
    }
*/



}
