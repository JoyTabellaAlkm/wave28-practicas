package com.example.concecionaria.repository;

import com.example.concecionaria.entity.Services;
import com.example.concecionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConsecionariaRepository {

    List<Services> services = List.of(
            new Services(LocalDate.of(2003, 5, 20), 60000, "Change air filters")
    );

    List<Vehicle> vehicles = List.of(
            new Vehicle(
                    "Chevrolet",
                    "Corsa",
                    LocalDate.of(2000, 11, 20),
                    115000,
                    5,
                    90000,
                    "AR",
                    services,
                    2
            )
    );

    public List<Vehicle> findAllProducts(){
        return vehicles;
    }
    public List<Vehicle> findAllProductsBetweenDates(LocalDate since,LocalDate to){
        List<Vehicle> filteredVehicles = vehicles.stream()
                .filter(v -> !v.getManufactoringDate().isBefore(since) && !v.getManufactoringDate().isAfter(to))
                .toList();

        return filteredVehicles;
    }

    public List<Vehicle> findAllProductsBetweenPrice(int since, int to){
        List<Vehicle> filteredVehicles = vehicles.stream()
                .filter(v -> v.getPrice() > since && v.getPrice()< to)
                .toList();
        return filteredVehicles;
    }

}
