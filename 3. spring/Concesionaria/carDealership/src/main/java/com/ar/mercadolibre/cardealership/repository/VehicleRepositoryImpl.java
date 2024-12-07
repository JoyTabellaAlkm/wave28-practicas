package com.ar.mercadolibre.cardealership.repository;

import com.ar.mercadolibre.cardealership.model.Maintenance;
import com.ar.mercadolibre.cardealership.model.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private final List<Vehicle> vehicleList;

    public VehicleRepositoryImpl() {
        vehicleList = new ArrayList<>( List.of(
                new Vehicle("Chevrolet", "Corsa", "2020-11-20", "115000", "5", "90000", "AR", new ArrayList<>(List.of(new Maintenance("2003-5-20", "60000", "Change air filters"))),"2"),
                new Vehicle("Ford", "Focus", "2021-11-20", "115000", "5", "75000", "AR", new ArrayList<>(List.of(new Maintenance("2003-5-20", "60000", "Change air filters"))),"2"),
                new Vehicle("Toyota", "Corolla", "2022-11-20", "115000", "5", "60000", "AR", new ArrayList<>(List.of(new Maintenance("2003-5-20", "60000", "Change air filters"))),"2")
        ));
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleList;
    }

    @Override
    public List<Vehicle> getByManufacturingDateRange(String from, String to) {
        LocalDate fromDate = stringToLocalDate(from);
        LocalDate toDate = stringToLocalDate(to);

        return vehicleList.stream().filter(vehicle -> {
            LocalDate manufacturingDate = stringToLocalDate(vehicle.getManufacturingDate());

            return (manufacturingDate.isAfter(fromDate) || manufacturingDate.isEqual(fromDate)) && (manufacturingDate.isBefore(toDate) || manufacturingDate.isEqual(toDate));
        }).toList();
    }

    @Override
    public List<Vehicle> getByPriceRange(String from, String to) {
        Double fromDouble = stringToDouble(from);
        Double toDouble = stringToDouble(to);

        return vehicleList.stream().filter(vehicle -> {
           Double price = stringToDouble(vehicle.getPrice());

           return price >= fromDouble && price <= toDouble;
        }).toList();
    }

    @Override
    public Vehicle getById(Long id) {
        Optional<Vehicle> vehicle = vehicleList.stream().filter(vehicle1 -> vehicle1.getId().equals(id)).findFirst();
        return vehicle.orElse(null);
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return vehicle;
    }

    private Double stringToDouble(String price) {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(price, Double.class);
    }

    private LocalDate stringToLocalDate(String date) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return mapper.convertValue(date, LocalDate.class);
    }
}
