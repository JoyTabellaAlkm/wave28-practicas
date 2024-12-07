package com.ar.mercadolibre.cardealership.dto.request;

import com.ar.mercadolibre.cardealership.dto.response.MaintenanceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleCreationDTO {

    private String brand;
    private String model;
    private String  manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<MaintenanceDTO> services;
    private String countOfOwners;
}
