package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleBadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleIdAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto crearVehiculo(Vehicle vehiculo) {
        ObjectMapper mapper = new ObjectMapper();
        if (vehicleRepository.findById(vehiculo.getId()) != null) {
            throw new VehicleIdAlreadyExistsException("El vehículo con el ID " + vehiculo.getId() + " ya existe en el sistema.");
        }
        if (vehiculo.getBrand() == null || vehiculo.getModel() == null) {
            throw new VehicleBadRequestException("Datos del vehículo mal formados o incompletos. Asegúrese de proporcionar la marca, modelo y placa.");
        }
        vehicleRepository.crearVehiculo(vehiculo);
        return mapper.convertValue(vehiculo, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> vehiculoColoryAnio(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        List<VehicleDto> filteredList = vehicleList.stream()
                .filter(entry -> entry.getColor().equals(color) && entry.getYear() == year)
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
        if(filteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return filteredList;
    }

    @Override
    public List<VehicleDto> vehiculoMarcayAnio(String marca, int start_year, int end_year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        List<VehicleDto> filteredList = vehicleList.stream()
                .filter(entry -> entry.getBrand().equals(marca))
                .filter(entry -> entry.getYear() >= start_year && entry.getYear() <= end_year)
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
        if(filteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return filteredList;
    }

    @Override
    public String promedioVelocidadxMarca(String brand) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        List<VehicleDto> filteredList = vehicleList.stream()
                .filter(entry -> entry.getBrand().equals(brand))
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
        if(filteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esta marca.");
        }
        double promedio = 0;
        for(VehicleDto entry: filteredList){
            promedio += Double.parseDouble(entry.getMax_speed());
        }
        promedio /= filteredList.size();
        return("El promedio de velocidad de los vehiculos " + brand + " es: " + promedio);
    }

    @Override
    public String crearVehiculos(List<Vehicle> vehiculos) {
        for (Vehicle entry: vehiculos){
            if (vehicleRepository.findById(entry.getId()) != null) {
                throw new VehicleIdAlreadyExistsException("El vehículo con el ID " + entry.getId() + " ya existe en el sistema.");
            }
            if (entry.getBrand() == null || entry.getModel() == null) {
                throw new VehicleBadRequestException("Datos del vehículo mal formados o incompletos. Asegúrese de proporcionar la marca, modelo y placa.");
            }
        }
        vehicleRepository.crearVehiculos(vehiculos);
        return("Vehículos creados exitosamente.");
    }

    @Override
    public String eliminarVehiculo(int id) {
        vehicleRepository.eliminarVehiculo(id);
        return("Vehiculo con el id " + id + " fue eliminado exitosamente");
    }

    @Override
    public VehicleDto actualizarVelocidad(int id, int velocidad) {
        ObjectMapper mapper = new ObjectMapper();
        if(velocidad > 300){
            throw new VehicleBadRequestException("Velocidad mal formada o fuera de rango.");
        }
        Vehicle vehicle = vehicleRepository.actualizarVelocidad(id, velocidad);
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public String actualizarCombustible(int id) {

        return null;
    }
}
