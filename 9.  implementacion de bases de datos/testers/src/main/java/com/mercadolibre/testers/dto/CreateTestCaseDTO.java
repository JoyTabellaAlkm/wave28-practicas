package com.mercadolibre.testers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTestCaseDTO {
    String description;
    Boolean tested;
    Boolean passed;
    int numberOfTries;
    LocalDate lastUpdate;
}
