package com.mercadolibre.vehicles.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ServiceVehicleIdDto {

	private Integer id;
	private LocalDate date;
	private String kilometers;
	private String descriptions;

}
