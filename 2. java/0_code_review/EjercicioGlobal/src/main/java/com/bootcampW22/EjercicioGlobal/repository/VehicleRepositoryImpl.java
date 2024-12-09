package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
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
    public String save(Vehicle vehicle){
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        listOfVehicles.add(vehicle);

        try{
            file = ResourceUtils.getFile("classpath:vehicles_100.json");
            objectMapper.writeValue(file, listOfVehicles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Vehículo creado exitosamente";
    }

    @Override
    public void update(List<Vehicle> vehicleList) {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            file = ResourceUtils.getFile("classpath:vehicles_100.json");
            objectMapper.writeValue(file, vehicleList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(List<Vehicle> vehicleList) {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            file = ResourceUtils.getFile("classpath:vehicles_100.json");
            objectMapper.writeValue(file, vehicleList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
