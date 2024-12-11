package com.bootcamp.practicacodereviewi.repository;

import com.bootcamp.practicacodereviewi.dto.VehicleDto;
import com.bootcamp.practicacodereviewi.entity.Vehicle;
import com.bootcamp.practicacodereviewi.exception.BadRequestException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Vehicle createVehicle(VehicleDto vehicleDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Vehicle vehicleCreated = objectMapper.convertValue(vehicleDto, Vehicle.class);
        listOfVehicles.add(vehicleCreated);
        return vehicleCreated;
    }

    @Override
    public List<Vehicle> createListOfVehicles(List<VehicleDto> vehiclesDtos) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehiclesToAdd = vehiclesDtos.
                stream().
                map(v -> objectMapper.convertValue(v, Vehicle.class)).
                toList();

        boolean insertedSuccesfully = listOfVehicles.addAll(vehiclesToAdd);
        if (!insertedSuccesfully) {
            throw new BadRequestException("Verifique la correctitud de los datos ingresados");
        }
        return vehiclesToAdd;
    }

    @Override
    public boolean deleteVehicle(Long id) {
        Vehicle vehicleToDelete = listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst().get();
        return listOfVehicles.remove(vehicleToDelete);
    }

    @Override
    public Vehicle updateVehicle(Long idUpdatedVehicle, Vehicle newVehicle) {
        listOfVehicles.stream().filter(v -> v.getId().equals(idUpdatedVehicle)).forEach(
                v -> {
                    v.setBrand(newVehicle.getBrand());
                    v.setModel(newVehicle.getModel());
                    v.setHeight(newVehicle.getHeight());
                    v.setColor(newVehicle.getColor());
                    v.setPassengers(newVehicle.getPassengers());
                    v.setFuel_type(newVehicle.getFuel_type());
                    v.setTransmission(newVehicle.getTransmission());
                    v.setRegistration(newVehicle.getRegistration());
                    v.setWeight(newVehicle.getWeight());
                    v.setYear(newVehicle.getYear());
                    v.setWidth(newVehicle.getWidth());
                    v.setMax_speed(newVehicle.getMax_speed());
                }
        );
        return listOfVehicles.stream().filter(v -> v.getId().equals(idUpdatedVehicle)).findFirst().get();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
