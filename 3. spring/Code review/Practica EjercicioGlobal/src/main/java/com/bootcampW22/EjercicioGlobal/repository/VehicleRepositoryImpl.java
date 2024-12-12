package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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
    public Vehicle crearVehiculo(Vehicle vehiculo) {
        listOfVehicles.add(vehiculo);
        return listOfVehicles.stream()
                .filter(entry -> entry.getId().equals(vehiculo.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void crearVehiculos(List<Vehicle> vehiculos) {
        for(Vehicle entry: vehiculos){
            listOfVehicles.add(entry);
        }
    }

    @Override
    public Vehicle actualizarVelocidad(int id, int velocidad) {
        String velocidadFormateada = String.valueOf(velocidad);
        return listOfVehicles.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .map(entry -> {
                    entry.setMax_speed(velocidadFormateada);
                    return entry;
                })
                .orElseThrow(() -> new NotFoundException("No se encontró el vehículo con el id " + id));
    }

    @Override
    public Vehicle findById(long id) {
        return listOfVehicles.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Vehicle eliminarVehiculo(int id) {
        Vehicle vehiculoEliminado = listOfVehicles.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("No se encontro el vehiculo con el id " + id));
        listOfVehicles.removeIf(entry -> entry.getId() == id);
        return vehiculoEliminado;
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
