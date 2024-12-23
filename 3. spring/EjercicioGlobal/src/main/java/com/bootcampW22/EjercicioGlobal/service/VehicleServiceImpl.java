package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.InvalidFormatException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
    ObjectMapper mapper;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.mapper = new ObjectMapper();
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchByDimension(String length, String width) {
        Double min_length_double;
        Double max_length_double;
        Double min_width_double;
        Double max_width_double;
        try{
            String[] lengths = length.split("-");
            String[] widths = width.split("-");
             min_length_double = Double.valueOf(lengths[0]);
             max_length_double = Double.valueOf(lengths[1]);
             min_width_double = Double.valueOf(widths[0]);
             max_width_double =Double.valueOf(widths[1]);
        }catch (NumberFormatException e){
            throw new InvalidFormatException("Ingrese valores correctos para el largo y ancho");
        }
        List<Vehicle> vehicleList = vehicleRepository.findAll()
                .stream()
                .filter(vehicle -> vehicle.getHeight()>min_length_double && vehicle.getHeight()<max_length_double&&vehicle.getWidth()>min_width_double &&vehicle.getWidth()<max_width_double)
                .toList();
        if (vehicleList.isEmpty()) throw new NotFoundException("No existen vehiculos con estas caracteristicas");

        List<VehicleDto> listVehicleDto = mapper.convertValue(vehicleList, new TypeReference<List<VehicleDto>>() {});
        return listVehicleDto;

    }

}
