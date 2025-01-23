package com.example.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record TestCaseRequestDtoR(
        String description,
        Boolean tested,
        Boolean passed,
        @JsonProperty("number_of_tries")
        int numberOfTries,
        @JsonProperty("last_update")
        LocalDate lastUpdate
) {
}
