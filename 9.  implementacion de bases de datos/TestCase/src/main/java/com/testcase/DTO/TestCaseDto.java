package com.testcase.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDto {
    @NotBlank
    private String description;

    @NotNull
    private Boolean tested;

    private Boolean passed;

    @Min(value = 1, message = "id no valido")
    @NotNull
    private int numberOfTries;

    @NotNull
    private LocalDate lastUpdate;
}
