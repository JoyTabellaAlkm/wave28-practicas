package com.example.testcasesapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTestCaseDto {
    @JsonProperty("id_case")
    @NotNull(message = "El id_case no puede estar vacio")
    private Long idCase;

    @NotNull(message = "El descripcion no puede estar vacio")
    private String description;

    @NotNull(message = "tested no puede estar vacio")
    private Boolean tested;

    @NotNull(message = "passed no puede estar vacio")
    private Boolean passed;

    @JsonProperty("number_of_tries")
    @NotNull(message = "number_of_tries no puede estar vacio")
    @Min(value = 0, message = "El numero de intentos no puede ser menor a 0.")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    @NotNull(message = "last_update no puede estar vacio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate lastUpdate;
}
