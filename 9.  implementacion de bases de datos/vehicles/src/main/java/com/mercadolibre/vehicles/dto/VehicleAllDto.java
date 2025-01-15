package com.mercadolibre.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleAllDto {

	private Integer id;
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

}
