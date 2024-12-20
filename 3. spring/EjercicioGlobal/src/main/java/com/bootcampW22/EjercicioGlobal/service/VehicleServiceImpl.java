package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
    ObjectMapper mapper = new ObjectMapper();

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> findAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningún auto en el sistema");
        }
        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    //Busca por id y devuelve el vehiculo con ese id (lanza una excepcion si no existe)
    @Override
    public Vehicle findById(Long id){
        return vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró el vehículo"));
    }

    //Busca por id y lanza una excepcion si ya existe
    public void vehicleExist(Long id){
        if (vehicleRepository.findById(id).isPresent()){
            throw new ConflictException("El vehiculo con ese ID ya existe");
        }
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
    public List<VehicleDto> findByColorAndYear(String color, int year){
        List<Vehicle> vehicleList = vehicleRepository.findByColorAndYear(color, year);
        if (vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro un vehiculo con ese color y ese año");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findByBrandAndAgeRange(String brand, Integer start_year, Integer end_year){
        List<Vehicle> vehicleList = vehicleRepository.findByBrandAndAgeRange(brand, start_year, end_year);
        if (vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro vehículos de una marca específica fabricados en un rango de años");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Double findByAverageSpeedByBrand(String brand){
        Double averageBrand = vehicleRepository.findByAverageSpeedByBrand(brand);
        if (averageBrand == 0.0){
            throw new NotFoundException("No se encontraron vehiculos de esa marca");
        }
        return averageBrand;
    }

    @Override
    public List<VehicleDto> findByFuelType(String type){
        List<Vehicle> vehicleList = vehicleRepository.findByFuelType(type);
        if (vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findByTransmissionType(String transmission) {
        List<Vehicle> vehicleList = vehicleRepository.findByTransmissionType(transmission);
        if (vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findByDimensions(String length,  String width) {
        String[] lengthRange = length.split("-");
        double min_length = Double.parseDouble(lengthRange[0]);
        double max_length = Double.parseDouble(lengthRange[1]);
        String[] widthRange = width.split("-");
        double min_width = Double.parseDouble(widthRange[0]);
        double max_width = Double.parseDouble(widthRange[1]);

        List<Vehicle> vehicleList = vehicleRepository.findByDimensions(min_length, max_length, min_width, max_width);
        if (vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findByWeightRange(double weight_min, double weight_max) {
        List<Vehicle> vehicleList = vehicleRepository.findByWeightRange(weight_min, weight_max);
        if (vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Double averageCapacityByBrand(String brand) {
        Double average = vehicleRepository.averageCapacityByBrand(brand);
        if (average == 0.0){
            throw new NotFoundException("No se encontraron vehiculos de esa marca");
        }
        return average;
    }

    @Override
    public String remove(Long id) {
        Vehicle vehicle = findById(id);
        return vehicleRepository.remove(vehicle);
    }

    @Override
    public String save(VehicleDto vehicle) {
        Optional<Vehicle> vehicleId = vehicleRepository.findById(vehicle.getId());
        if (vehicleId.isPresent()){
            throw new ConflictException("Identificador del vehículo ya existente.");
        }
        validateVehicle(vehicle);
        return vehicleRepository.save(mapper.convertValue(vehicle,Vehicle.class));
    }

    @Override
    public String saveMany(List<VehicleDto> vehicles) {
        vehicles.forEach(vehicle -> vehicleExist(vehicle.getId()));
        vehicles.forEach(v -> validateVehicle(v));
        List<Vehicle> vehicleList = vehicles.stream()
                .map(vehicleDto -> mapper.convertValue(vehicleDto, Vehicle.class))
                .toList();
        return vehicleRepository.saveMany(vehicleList);
    }

    @Override
    public String updateMaxSpeed(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = findById(id);
        try {
            double max_speed = Double.parseDouble(vehicleDto.getMax_speed());
            if (max_speed <= 0 || max_speed > 500){
                throw new BadRequestException("Velocidad mal formada o fuera de rango");
            }
        } catch (NullPointerException | NumberFormatException e){
            throw new BadRequestException("Velocidad mal formada o fuera de rango");
        }
        return vehicleRepository.updateMaxSpeed(vehicle, vehicleDto.getMax_speed());
    }

    @Override
    public String updateFuelType(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = findById(id);
        if (vehicleDto.getFuel_type() == null || vehicleDto.getFuel_type().isEmpty()){
            throw new BadRequestException("Tipo de combustible mal formado o no admitido.");
        }
        return vehicleRepository.updateFuelType(vehicle, vehicleDto.getFuel_type());
    }

    private void validateVehicle(VehicleDto vehicle){
        if (vehicle.getBrand() == null){ //agregar los demas
            throw new BadRequestException("Datos del vehículo mal formados o incompletos");
        }
    }
}
