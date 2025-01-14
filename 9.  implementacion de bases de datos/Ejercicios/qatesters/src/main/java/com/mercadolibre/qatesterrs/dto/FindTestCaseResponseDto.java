package com.mercadolibre.qatesterrs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindTestCaseResponseDto {

	private long id;

	private String description;

	private boolean tested;

	private boolean passed;

	@JsonProperty(value = "number_of_tries")
	private int numberOfTries;

	@JsonProperty(value = "last_update")
	private LocalDate lastUpdate;

}
