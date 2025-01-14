package com.mercadolibre.qatesterrs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateTestCaseRequestDto {

	@NotBlank
	private String description;

	private boolean tested;

	private boolean passed;

	@Min(1)
	@JsonProperty(value = "number_of_tries")
	private int numberOfTries;

}
