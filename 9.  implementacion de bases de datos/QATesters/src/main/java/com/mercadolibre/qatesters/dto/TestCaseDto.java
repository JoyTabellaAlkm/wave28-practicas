package com.mercadolibre.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TestCaseDto {
    String description;
    Boolean tested;
    Boolean passed;
    @JsonProperty("number_of_tries")
    int numberOfTries;
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}
