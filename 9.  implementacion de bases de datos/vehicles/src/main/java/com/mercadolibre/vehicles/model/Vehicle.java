package com.mercadolibre.vehicles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column
	private String brand;

	@Column
	private String model;

	@Column(name = "manufacturing_date")
	private LocalDate manufacturingDate;

	@Column(name = "number_of_kilometers")
	private String numberOfKilometers;

	@Column
	private String doors;

	@Column
	private String price;

	@Column
	private String currency;

	@Column(name = "count_of_owners")
	private String countOfOwners;

	@OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
	private List<ServiceModel> serviceModels;

}
