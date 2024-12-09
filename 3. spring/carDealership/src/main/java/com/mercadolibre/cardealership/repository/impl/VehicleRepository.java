package com.mercadolibre.cardealership.repository.impl;

import com.mercadolibre.cardealership.model.Service;
import com.mercadolibre.cardealership.model.Vehicle;
import com.mercadolibre.cardealership.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepository implements IVehicleRepository {

    private final List<Vehicle> vehicles;
    private Integer vehicleId;
    private Integer serviceId;

    public VehicleRepository() {
        serviceId = 1;
        vehicles = new ArrayList<>();
        vehicleId = 1;
        fillData();
    }

    @Override
    public String save(Vehicle vehicle) {
        vehicle.setId(vehicleId++);
        if (!vehicle.getServices().isEmpty()){
            for (Service service : vehicle.getServices()){
                service.setId(serviceId++);
            }
        }
        vehicles.add(vehicle);

        return "Vehículo guardado con éxito";
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> findByManufacturingDate(LocalDate since, LocalDate to) {
        return vehicles.stream()
                .filter( vehicle -> vehicle.getManufacturingDate().isAfter(since) && vehicle.getManufacturingDate().isBefore(to))
                .toList();
    }

    @Override
    public List<Vehicle> findByPrice(Double since, Double to) {
        return vehicles.stream()
                .filter( vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                .toList();
    }

    @Override
    public Optional<Vehicle> findById(Integer id) {
        return vehicles.stream().
                filter( vehicle -> vehicle.getId().equals(id))
                .findFirst();
    }


    private void fillData() {
        Service service1 = new Service(serviceId++, LocalDate.of(2015, 5, 16), 45, "Cambio de aceite");
        Service service2 = new Service(serviceId++, LocalDate.of(2016, 8, 21), 120, "Revisión general");
        Service service3 = new Service(serviceId++, LocalDate.of(2017, 3, 10), 75, "Cambio de frenos");
        Service service4 = new Service(serviceId++, LocalDate.of(2019, 11, 5), 50, "Cambio de batería");
        Service service5 = new Service(serviceId++, LocalDate.of(2021, 6, 3), 100, "Reemplazo de neumáticos");

        vehicles.add(new Vehicle(vehicleId++, "Chevrolet", "Corsa", LocalDate.of(2000, 11, 20), 115000.0, 5, 90000.0, "AR", 2, List.of(service1)));
        vehicles.add(new Vehicle(vehicleId++, "Ford", "Fiesta", LocalDate.of(2010, 3, 5), 75000.0, 4, 120000.0, "AR", 1, List.of(service2, service3)));
        vehicles.add(new Vehicle(vehicleId++, "Renault", "Clio", LocalDate.of(2005, 6, 15), 95000.0, 4, 80000.0, "AR", 3, List.of(service4)));
        vehicles.add(new Vehicle(vehicleId++, "Volkswagen", "Gol", LocalDate.of(2018, 9, 25), 30000.0, 5, 250000.0, "AR", 1, new ArrayList<>()));
        vehicles.add(new Vehicle(vehicleId++, "Toyota", "Corolla", LocalDate.of(2015, 12, 30), 60000.0, 4, 200000.0, "AR", 2, List.of(service5)));
    }
}
