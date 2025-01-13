package com.mercadolibre.qatesterrs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tests_case")
public class TestCase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column
	private String description;

	@Column
	private boolean tested;

	@Column
	private boolean passed;

	@Column(name = "number_of_tries")
	private int numberOfTries;

	@Column(name = "last_update")
	private LocalDate lastUpdate;

}
