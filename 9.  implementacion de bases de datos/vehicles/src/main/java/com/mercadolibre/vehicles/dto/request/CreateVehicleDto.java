package com.mercadolibre.vehicles.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleDto {

	private String brand;
	private String model;

	@JsonProperty("manufacturing_date")
	private LocalDate manufacturingDate;

	@JsonProperty("number_of_kilometers")
	private String numberOfKilometers;
	private String doors;
	private String price;
	private String currency;

	@JsonProperty("count_of_owners")
	private String countOfOwners;
	private List<CreateServiceDto> services;

}
