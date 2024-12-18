package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestCarExection;
import com.bootcampW22.EjercicioGlobal.exception.ConflicException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ResponseDTO addCar(VehicleDto car){
        ResponseDTO res = new ResponseDTO();
        boolean vehicule = searchAllVehicles().stream().filter(x ->  x.getId().equals(car.getId())).findFirst().isEmpty();
        if(!vehicule) {
            throw new ConflicException("vehículo ya existente.");
        }
        if (car == null || car.getId() < 0) {
            throw new ConflicException("Datos del vehículo mal formados o incompletos");
        }
        ObjectMapper obj = new ObjectMapper();
        res.setResponce(vehicleRepository.addCar(obj.convertValue(car,Vehicle.class)));
        return res;
    }

    @Override
    public ResponseDTO addCars(List<VehicleDto> cars) {
        ObjectMapper obj = new ObjectMapper();
        ResponseDTO response = new ResponseDTO();
        List<Vehicle> carsEntity = new ArrayList<>();
        carsEntity = cars.stream().map( x -> obj.convertValue(x,Vehicle.class)).toList();
        for(Vehicle car: carsEntity){
            boolean vehicule = searchAllVehicles().stream().filter(x ->  x.getId().equals(car.getId())).findFirst().isEmpty();
            if(!vehicule) {
                throw new ConflicException("vehículo ya existente.");
            }
            if (car == null || car.getId() < 0) {
                throw new ConflicException("Datos del vehículo mal formados o incompletos");
            }
        }
        String res =vehicleRepository.addCars(carsEntity);
        response.setResponce(res);
        return response;
    }

    @Override
   public List<VehicleDto> findCarByColorAndYear(String color, int year) {
        List<VehicleDto> res = new ArrayList<>();
        ObjectMapper obj = new ObjectMapper();
        List<VehicleDto> cars = vehicleRepository.findCarByColorAndYear(color,year).stream().map( c -> obj.convertValue(c,VehicleDto.class)).toList();
        if(cars.size() > 0){
            return cars;
        }else{
            throw new NotFoundException("no se encontraron carros con ese color y año");
        }
    }

    @Override
    public List<VehicleDto> findCarsByBrandAndYear(String brand, int startYear, int endYear) {
        List<VehicleDto> res = new ArrayList<>();
        ObjectMapper obj = new ObjectMapper();
        List<VehicleDto> cars = vehicleRepository.findCarsByBrandAndYear(brand,startYear,endYear).stream().map( c -> obj.convertValue(c,VehicleDto.class)).toList();
        if(cars.size() > 0){
            return cars;
        }else{
            throw new NotFoundException("no se encontraron vehiculos con esos criterios");
        }
    }

    @Override
    public ResponseDTO findAverageMaxSpeedByBrand(String brand) {
        ResponseDTO res = new ResponseDTO();
        double average = vehicleRepository.calAverageSpeedByBrand(brand);
        res.setResponce("La velocidad promedio de la marca " + brand + " es: " + average);
        return res;
    }

    @Override
    public ResponseDTO updateMaxSpeed(int id, UpdateSpeedRequesDTO max_speed) {
        ResponseDTO response = new ResponseDTO();
        vehicleRepository.findAll().
                stream().
                filter(x -> x.getId() == id).
                findFirst().
                orElseThrow( () -> new NotFoundException("No se encontro el vehiculo"));
        int validSpeed = Integer.parseInt(max_speed.getMax_speed());
        if( validSpeed > 400 || validSpeed < 0){
            throw new ConflicException("velocidad mal formada o fuera de rango");
        }
        response.setResponce(vehicleRepository.updateMaxSpeed(id,max_speed.getMax_speed()));
        return response;
    }

    @Override
    public ResponseDTO deleteCar(int id) {
        ResponseDTO response = new ResponseDTO();
        Vehicle car =  vehicleRepository.findAll().stream().filter(c -> c.getId() == id).findFirst().orElseThrow( () -> new NotFoundException("No se encontró el vehículo."));
        response.setResponce(vehicleRepository.deleteCar(car));
        return response;
    }

    @Override
    public List<VehicleDto> findVehiclesTransmissionByType(String type) {
        List<VehicleDto> response = new ArrayList<>();
        ObjectMapper obj = new ObjectMapper();
        response = vehicleRepository.getVehiclesByTranssmission(type).stream().map(x -> obj.convertValue(x,VehicleDto.class)).toList();
        if(response.isEmpty()){
           throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }
        return response;

    }

    @Override
    public ResponseDTO putUpdateByTypeFuel(int id, UpdateFuelByIdRequestDTO fuel) {
        ResponseDTO response = new ResponseDTO();
        vehicleRepository.findAll().stream().filter(x -> x.getId() == id).findFirst().orElseThrow( () -> new NotFoundException("No se encontró el vehículo."));
        if(fuel.getType_fuel().isEmpty()){
            throw new BadRequestCarExection("Tipo de combustible mal formado o no admitido.");
        }
        response.setResponce(vehicleRepository.putTypeFuel(id,fuel.getType_fuel()));
        return response;
    }

    @Override
    public AverageCapacityResponseDTO averageByPassengers(String brand) {
        AverageCapacityResponseDTO response = new AverageCapacityResponseDTO();
        response.setBrand(brand);
        response.setAverage(vehicleRepository.averageByBrand(brand));
        return response;
    }

    @Override
    public List<VehicleDto> findByLarge(String legnth,String width) {
        String[] len = legnth.split("-");
        String[] wid = width.split("-");
        List<VehicleDto> cars = new ArrayList<>();
        ObjectMapper objt = new ObjectMapper();
        cars = vehicleRepository.findByLarge(Double.parseDouble(len[0]),Double.parseDouble(len[1]),Double.parseDouble(wid[0]),Double.parseDouble(wid[1])).stream().map( car -> objt.convertValue(car,VehicleDto.class)).toList();
        if(cars.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }
        return cars;
    }

    @Override
    public List<VehicleDto> findCarsByWeight(double min, double max) {
        List<VehicleDto> response = new ArrayList<>();
        ObjectMapper objt = new ObjectMapper();
        response = vehicleRepository.findCarsByRangeWeight(min,max).stream().map( car -> objt.convertValue(car,VehicleDto.class)).toList();
        if(response.isEmpty()){
            throw new NotFoundException(" No se encontraron vehículos en ese rango de peso.");
        }
        return response;
    }


}
