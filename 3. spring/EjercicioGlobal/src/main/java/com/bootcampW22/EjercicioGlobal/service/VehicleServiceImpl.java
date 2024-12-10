package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.UpdateVehicleBySpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.RecordFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
    private ObjectMapper mapper = new ObjectMapper();
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
    public String getAllVehiclesByBrand(String brand) {
        List<Vehicle> allVehicle = vehicleRepository.findAll()
                .stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .toList();

        if(allVehicle.isEmpty()){
            throw new BadRequestException("No se encontraron vehículos de esa marca");
        }

        double averageSpeed = allVehicle.stream()
                .mapToDouble(vehicle -> {
                    try{
                         Double average = Double.parseDouble(vehicle.getMax_speed());
                         return average;
                    }catch (NumberFormatException e){
                        throw new BadRequestException(e.getMessage());
                    }
                })
                .average()
                .orElse(0.0);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(averageSpeed);
    }

    @Override
    public List<VehicleDto> getAllVehiclesByFullSpeed(String type) {

        List<VehicleDto> allVehicle = vehicleRepository.findAll()
                .stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type))
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        if(allVehicle.isEmpty()){
            throw new BadRequestException("No se encontraron vehiculos con estas especificaciones");
        }

        return allVehicle;
    }

    @Override
    public ResponseDTO deleteVehicleById(int id) {

        List<Vehicle> allVehicle = vehicleRepository.findAll();
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);

        Vehicle vehicleFound = optionalVehicle.orElseThrow(()-> new BadRequestException("No se encontro el vehiculo"));

        Boolean isRemoved = allVehicle.remove(vehicleFound);

        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setMessage(isRemoved ? "Vehiculo eliminado exitosamente" : "No se pudo eliminar el vehiculo");
        return responseDto;

    }

    @Override
    public ResponseDTO createVehicle(VehicleDto vehicleDto) {

        if (vehicleDto == null || vehicleDto.getId() == null) {
            throw new BadRequestException("Datos del vehículo mal formados o incompletos.");
        }

        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleDto.getId());

        if(!vehicle.isEmpty()){
            throw new RecordFoundException("Identificador del vehículo ya existente.");
        }

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        allVehicles.add(mapper.convertValue(vehicleDto, Vehicle.class));

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Agregado  correctamente");
        return  responseDTO;
    }

    @Override
    public ResponseDTO updateVehicleBySpeed(long id, UpdateVehicleBySpeedDTO updateVehicleBySpeedDTO) {

        if(updateVehicleBySpeedDTO.getMax_speed() == null || Integer.parseInt(updateVehicleBySpeedDTO.getMax_speed())  < 0 || Integer.parseInt(updateVehicleBySpeedDTO.getMax_speed()) > 200 ){
            throw new BadRequestException("Velocidad mal formada o fuera de rango.");
        }

        Optional<Vehicle> foundVehicle = vehicleRepository.findById(id);

        Vehicle vehicle = foundVehicle.orElseThrow(() -> new BadRequestException("No se encontró el vehículo"));

        vehicle.setMax_speed(updateVehicleBySpeedDTO.getMax_speed());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Actualizado correctamente");
        return responseDTO;
    }

    @Override
    public ResponseDTO createMultipleVehicles(List<VehicleDto> vehiclesDtos) {

        vehiclesDtos.forEach(vehicleDto ->{

            if(vehicleDto.getId() == null || vehicleDto == null){
                throw new BadRequestException("Datos de algún vehículo mal formados o incompletos");
            }

            Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleDto.getId());

            if (vehicle.isPresent()){
                throw new RecordFoundException("Algún vehículo tiene un identificador ya existente.");
            }

           Vehicle vehicleModel = mapper.convertValue(vehicleDto, Vehicle.class);
           vehicleRepository.save(vehicleModel);

        });

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Vehiculos creados");
        return responseDTO;
    }

    @Override
    public List<VehicleDto> findAllVehicleWithSpecificDimensions(String height, String width) {

        try {
            String[] heightRange = height.split("-");
            String[] widthRange = width.split("-");

            Integer minHeight = Integer.parseInt(heightRange[0]);
            Integer maxLength = Integer.parseInt(heightRange[1]);

            Integer minWidth = Integer.parseInt(widthRange[0]);
            Integer maxWidth = Integer.parseInt(widthRange[1]);

            List<Vehicle> vehicles = vehicleRepository.findAll()
                    .stream()
                    .filter(vehicle ->
                            ((vehicle.getHeight() >= minHeight && vehicle.getHeight() <= maxLength) && (vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth))
                    ).toList();

            if(vehicles.isEmpty()){
                throw new BadRequestException("No se encontraron vehiculos con estas especificaciones");
            }

            List<VehicleDto> allVehicleDtos = vehicles.stream()
                    .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                    .toList();

            return allVehicleDtos;
        } catch (RuntimeException e) {
            throw new BadRequestException("Parametros mal formateados");
        }
    }

    @Override
    public List<VehicleDto> findAllVehiclesWithSpecificWeigth(int min, int max) {

        if((max > min) || min < 0) {
            throw new BadRequestException("Parametro invalidos");
        }

        List<Vehicle> vehicles = vehicleRepository.findAll()
                .stream()
                .filter(vehicle -> vehicle.getWeight() >= min && vehicle.getWeight() <= max)
                .toList();

        if (vehicles.isEmpty()){
            throw new BadRequestException("No se encontraron vehiculos con estas especificaciones");
        }

        List<VehicleDto> vehicleDtos = vehicles
                .stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        return vehicleDtos;
    }


}
