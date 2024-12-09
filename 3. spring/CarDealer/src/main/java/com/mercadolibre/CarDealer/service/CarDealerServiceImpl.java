package com.mercadolibre.CarDealer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.CarDealer.dto.CarDTO;
import com.mercadolibre.CarDealer.dto.ServiceDTO;
import com.mercadolibre.CarDealer.entity.CarEntity;
import com.mercadolibre.CarDealer.entity.ServiceEntity;
import com.mercadolibre.CarDealer.repository.ICarDealerRepository;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarDealerServiceImpl implements ICarDealearService{
    @Autowired
    ICarDealerRepository repository;
    @Override
    public void addCar(CarDTO car) {
        repository.addCar(mapperDtoToEntity(car));
    }

    @Override
    public List<CarDTO> listWithOutServices() {
        List<CarDTO> services = repository.
                listWithOutServices().
                stream().
                map(carEntity -> mapperEntityToDtoWithOutServices(carEntity))
                .toList();
        return services;
    }

    @Override
    public List<CarDTO> findByDate(Date since, Date to) {
        return repository.findByDate(since, to).stream().map(carEntity -> mapperEntityToDto(carEntity)).toList();
    }

    @Override
    public List<CarDTO> findByPrice(int since,int to) {
        return repository.findByPrice(since,to).stream().map(carEntity -> mapperEntityToDto(carEntity)).toList();
    }

    @Override
    public List<CarDTO> findById(int id) {
        return repository.findById(id).stream().map(carEntity -> mapperEntityToDto(carEntity)).toList();
    }

    public CarEntity mapperDtoToEntity(CarDTO car){
        List<ServiceEntity> services = new ArrayList<>();
        for(ServiceDTO s: car.getServices()){
            services.add(new ServiceEntity(
                    s.getDate(),
                    s.getKilometers(),
                    s.getDescription()
            ));
        }
        CarEntity carEntity = new CarEntity(
                11,
                car.getBrand(),
                car.getModel(),
                car.getManufacturingDate(),
                car.getNumberOfKilometers(),
                car.getDoors(),
                car.getPrice(),
                car.getCurrency(),
                services
        );
        return carEntity;
    }
    public CarDTO mapperEntityToDto(CarEntity car){
        List<ServiceDTO> services = new ArrayList<>();
        for(ServiceEntity s: car.getServices()){
            services.add(new ServiceDTO(
                    s.getDate(),
                    s.getKilometers(),
                    s.getDescription()
            ));
        }
        CarDTO carDto = new CarDTO(
                car.getBrand(),
                car.getModel(),
                car.getManufacturingDate(),
                car.getNumberOfKilometers(),
                car.getDoors(),
                car.getPrice(),
                car.getCurrency(),
                services
        );
        return carDto;
    }

    public CarDTO mapperEntityToDtoWithOutServices(CarEntity car){
        List<ServiceDTO> services = new ArrayList<>();
        CarDTO carDto = new CarDTO(
                car.getBrand(),
                car.getModel(),
                car.getManufacturingDate(),
                car.getNumberOfKilometers(),
                car.getDoors(),
                car.getPrice(),
                car.getCurrency(),
                services
        );
        return carDto;
    }
}
