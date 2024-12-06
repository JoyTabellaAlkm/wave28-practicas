package com.example.concesionaria.service;

import com.example.concesionaria.dto.request.VehicleRequestDto;
import com.example.concesionaria.dto.response.VehicleResponseDto;
import com.example.concesionaria.model.Vehicle;
import com.example.concesionaria.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    VehicleRepository repositorio;

    @Override
    public Integer agregarVehiculo(VehicleRequestDto vehiculo) {

        return repositorio.guardarVehiculo(new Vehicle(
                vehiculo.getBrand(),
                vehiculo.getModel(),
                vehiculo.getManufacturingDate(),
                vehiculo.getNumberOfKilometers(),
                vehiculo.getDoors(),
                vehiculo.getPrice(),
                vehiculo.getCurrency(),
                vehiculo.getServicios(),
                vehiculo.getCountOfOwners()
        ));
    }

    @Override
    public List<VehicleResponseDto> obtenerTodosLosVehiculos() {

        return repositorio.encontrarVehiculos().stream().map( vh -> new VehicleResponseDto(
                vh.getBrand(),
                vh.getModel(),
                vh.getManufacturingDate(),
                vh.getNumberOfKilometers(),
                vh.getDoors(),
                vh.getPrice(),
                vh.getCurrency(),
                vh.getCountOfOwners()
        )).toList();

    }

    @Override
    public VehicleResponseDto obtenerPorId(int id){
        Vehicle tempVehicle = repositorio.encontrarVehiculo(id);
        return new VehicleResponseDto(
                tempVehicle.getBrand(),
                tempVehicle.getModel(),
                tempVehicle.getManufacturingDate(),
                tempVehicle.getNumberOfKilometers(),
                tempVehicle.getDoors(),
                tempVehicle.getPrice(),
                tempVehicle.getCurrency(),
                tempVehicle.getCountOfOwners()
        );
    }

    @Override
    public List<VehicleResponseDto> obtenerPorFecha(String initialDate, String finalDate) {

        obtenerTodosLosVehiculos().stream().filter( vh -> {
            String actualDate = vh.getManufacturingDate().split("-")[0];
            
            return false;
        });
        return null;
    }

    @Override
    public List<VehicleResponseDto> obtenerPorPrecio(String initialPrice, String finalPrice) {
        return null;
    }
}
