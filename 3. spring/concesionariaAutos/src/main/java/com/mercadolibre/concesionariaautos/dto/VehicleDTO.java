package com.mercadolibre.concesionariaautos.dto;

import com.mercadolibre.concesionariaautos.model.Service;
import com.mercadolibre.concesionariaautos.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    public VehicleDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.manufacturingDate = vehicle.getManufacturingDate();
        this.numberOfKilometers = vehicle.getNumberOfKilometers();
        this.doors = vehicle.getDoors();
        this.price = vehicle.getPrice();
        this.currency = vehicle.getCurrency();
        if(!vehicle.getServices().isEmpty()) {
            this.services = vehicle.getServices()
                    .stream()
                    .map(s -> ServiceDTO.fromEntity(s))
                    .toList();
        }
        this.numberOfOwners = vehicle.getNumberOfOwners();
    }
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Double numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<ServiceDTO> services = new ArrayList<>();
    private Integer numberOfOwners;

    public static VehicleDTO fromEntity(Vehicle vehicle){
        return new VehicleDTO(vehicle);
    }

}