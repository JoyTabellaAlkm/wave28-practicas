package com.mercadolibre.ejercicio_global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
	private Long id;
	private String brand;
	private String model;
	private String registration;
	private String color;
	private int year;
	private String max_speed;
	private int passengers;
	private String fuel_type;
	private String transmission;
	private double height;
	private double width;
	private double weight;
}
