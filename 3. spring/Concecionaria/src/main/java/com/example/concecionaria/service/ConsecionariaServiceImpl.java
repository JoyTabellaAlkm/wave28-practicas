package com.example.concecionaria.service;

import com.example.concecionaria.dto.VehiclesDto;
import com.example.concecionaria.entity.Vehicle;
import com.example.concecionaria.repository.ConsecionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsecionariaServiceImpl implements IConcesionarioService{
    @Autowired
    private ConsecionariaRepository consecionariaRepository;

    @Override
    public List<VehiclesDto> getProducts() {
        List<Vehicle> vehicles = consecionariaRepository.findAllProducts();
        List<VehiclesDto> vehiclesDtoList = vehicles.stream()
                .map(v -> new VehiclesDto(
                        v.getBrand(),
                        v.getModel(),
                        v.getManufactoringDate(),
                        v.getNumberOfKilometers(),
                        v.getDoors(),
                        v.getPrice(),
                        v.getCurrency(),
                        v.getServices(),
                        v.getCountOfOwners()
                ))
                .collect(Collectors.toList());
        System.out.println(vehiclesDtoList);

        return vehiclesDtoList;
    }

    @Override
    public List<VehiclesDto> getProductsByDateOfCreation(LocalDate since,LocalDate to) {
        List<Vehicle> vehiclesFiltered = consecionariaRepository.findAllProductsBetweenDates(since,to);
        List<VehiclesDto> vehiclesBetweenDates = vehiclesFiltered.stream().map(v-> new VehiclesDto(
                v.getBrand(),
                v.getModel(),
                v.getManufactoringDate(),
                v.getNumberOfKilometers(),
                v.getDoors(),
                v.getPrice(),
                v.getCurrency(),
                v.getServices(),
                v.getCountOfOwners()
                )).toList();
        return vehiclesBetweenDates;
    }

    @Override
    public List<VehiclesDto> getProductsByPrice(int since, int to) {
        List<Vehicle> vehiclesFiltered = consecionariaRepository.findAllProductsBetweenPrice(since,to);
        List<VehiclesDto> vehiclesBetweenPrice = vehiclesFiltered.stream().map(v-> new VehiclesDto(
                v.getBrand(),
                v.getModel(),
                v.getManufactoringDate(),
                v.getNumberOfKilometers(),
                v.getDoors(),
                v.getPrice(),
                v.getCurrency(),
                v.getServices(),
                v.getCountOfOwners()
        )).toList();
        return vehiclesBetweenPrice;
    }
}
