package com.mercadolibre.concesionariaautos.dto;

import com.mercadolibre.concesionariaautos.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartialVehicleDTO {

    public PartialVehicleDTO(Vehicle vehicle) {
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.manufacturingDate = vehicle.getManufacturingDate();
        this.numberOfKilometers = vehicle.getNumberOfKilometers();
        this.doors = vehicle.getDoors();
        this.price = vehicle.getPrice();
        this.currency = vehicle.getCurrency();
        this.numberOfOwners = vehicle.getNumberOfOwners();
    }

    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Double numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer numberOfOwners;

    public static PartialVehicleDTO fromEntity(Vehicle vehicle){
        return new PartialVehicleDTO(vehicle);
    }


}
