package com.ar.mercadolibre.qatester.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCaseDTO {
    @JsonProperty("id_case")
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private int numberOfTries;
    @JsonProperty("last_update")
    @JsonFormat(pattern = "dd-MM-yyyy")  // Para serialización (salida del DTO)
    private LocalDate lastUpdate;
}
