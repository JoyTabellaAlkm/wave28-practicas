package com.mercadolibre.vehicles.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceDto {

	private LocalDate date;
	private String kilometers;
	private String descriptions;

}
