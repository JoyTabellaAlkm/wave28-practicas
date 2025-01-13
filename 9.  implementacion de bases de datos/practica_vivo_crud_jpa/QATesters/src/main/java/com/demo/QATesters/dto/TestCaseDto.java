package com.demo.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TestCaseDto {
    @NotNull(message = "Tiene que ingresar descripción")
    @Size(min = 3, message = "La descripción debe tener más de 3 caracteres")
    String description;
    Boolean tested;
    Boolean passed;
    @JsonProperty("number_of_tries")
    @Min(value = 0, message = "Los intentos deben ser mayores a 0")
    int numberOfTries = 0;
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}
