package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.DuplicateException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    IVehicleRepository vehicleRepository;
    @Autowired
    ObjectMapper objectMapper;

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
    public void addNewVehicle(VehicleDto vehicleDto) {
        if(isNull(getById(vehicleDto.getId()))){throw new DuplicateException("This element alredy exists");};
        if(!validateVehicleDTO(vehicleDto)){ throw new BadRequestException("Invalid data");}
        vehicleRepository.addNew(vehicleDto);
    }

    @Override
    public List<VehicleDto> getByColorAndYear(String color, Integer year) {
        List<VehicleDto> vehicles = vehicleRepository.getByColorAndYear(color, year);
        if(vehicles.isEmpty()){throw new NotFoundException("Not found");}
        return vehicles;
    }

    @Override
    public List<VehicleDto> findBetweenYears(String brand, Integer startYear, Integer endYear) {
        //Obtengo la lista completa
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        //La convierto en una lista filtrada por marca
        vehicleList = vehicleList.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .toList();
        System.out.println(vehicleList);
        if(vehicleList.isEmpty())throw new NotFoundException("No vehicles of such brand");
        //La filtro por años
        System.out.println(vehicleList);
        vehicleList = vehicleList.stream()
                .filter(vehicle -> vehicle.getYear() < endYear && vehicle.getYear() > startYear)
                .toList();
        if(vehicleList.isEmpty())throw new NotFoundException("No vehicles between those years");
        //Convierto y retorno la lista en DTO
        return vehicleList.stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public ResponseDTO findAverageSpeedByBrand(String brand) {
        //Obtengo la lista completa de vehiculos
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        //Filtro la lista por marca
        vehicleList = vehicleList.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .toList();
        if(vehicleList.isEmpty())throw new NotFoundException("No vehicles of that brand");
        //Obtengo la velocidad promedio
        Double averageSpeedByBrand = vehicleList.stream()
                .mapToDouble(value -> Double.parseDouble(value.getMax_speed()))
                .average()
                .orElse(0.0);
        return new ResponseDTO(
                Map.of("Brand", brand, "Average Speed", averageSpeedByBrand.toString())
        );
    }

    @Override
    public ResponseDTO postMultipleVehicles(List<VehicleDto> vehicles) {
        //Valido la lista de vehiculos
        List<VehicleDto> checkedVehicles = vehicles.stream().filter(this::validateVehicleDTO).toList();
        //Agrego cada uno de los vehiculos validados a la lista
        vehicles.forEach(vehicle -> vehicleRepository.addNew(vehicle));
        ResponseDTO response = new ResponseDTO();
        vehicles.forEach(vehicle -> response.setSingleProperty(vehicle.getId().toString(), String.valueOf(checkedVehicles.contains(vehicle))));
        return response;
    }

    @Override
    public ResponseDTO updateSpeed(Double speed, Long id) {
        //valido la velocidad
        if(speed < 1 || speed > 490) throw new BadRequestException("");
        //Obtengo la lista de vehiculos
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        //La filtro para encontrar el vehiculo deseado
        Vehicle vehicleToUpdate = vehicleList.stream().filter(vehicle -> vehicle.getId().equals(id)).findAny().orElse(null);
        if (vehicleToUpdate==null) throw new NotFoundException("Ese vehiculo no existe");

        //Persisto el cambio
        vehicleRepository.updateVehicle(vehicleToUpdate);
        return null;
    }

    public VehicleDto getById(Long id){
        return vehicleRepository.getById(id);
    }

    public <T> boolean isNull(T element){
        return element != null;
    }

    public boolean validateVehicleDTO(VehicleDto vehicleDto){
        return isNull(vehicleDto.getId()) &&
                isNull(vehicleDto.getBrand()) &&
                isNull(vehicleDto.getColor()) &&
                isNull(vehicleDto.getHeight()) &&
                isNull(vehicleDto.getModel()) &&
                isNull(vehicleDto.getPassengers()) &&
                isNull(vehicleDto.getFuel_type()) &&
                isNull(vehicleDto.getYear()) &&
                isNull(vehicleDto.getWeight()) &&
                isNull(vehicleDto.getMax_speed()) &&
                isNull(vehicleDto.getRegistration()) &&
                isNull(vehicleDto.getTransmission()) &&
                isNull(vehicleDto.getWidth());
    }
}
