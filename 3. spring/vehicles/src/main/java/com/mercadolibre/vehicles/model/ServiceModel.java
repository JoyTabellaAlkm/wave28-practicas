package com.mercadolibre.vehicles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceModel {

	private Integer id;
	private LocalDate date;
	private String kilometers;
	private String descriptions;

}
