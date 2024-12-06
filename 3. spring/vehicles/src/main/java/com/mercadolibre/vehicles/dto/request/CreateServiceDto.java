package com.mercadolibre.vehicles.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateServiceDto {

	private LocalDate date;
	private String kilometers;
	private String descriptions;

}
