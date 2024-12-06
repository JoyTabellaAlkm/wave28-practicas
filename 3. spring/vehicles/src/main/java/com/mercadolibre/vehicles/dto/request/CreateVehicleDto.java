package com.mercadolibre.vehicles.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateVehicleDto {

	private String brand;
	private String model;
	private LocalDate manufacturingDate;
	private String numberOfKilometers;
	private String doors;
	private String price;
	private String currency;
	private String countOfOwners;
	private List<CreateServiceDto> services;

}
