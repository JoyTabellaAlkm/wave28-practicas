package com.bootcamp.testcase.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTestCaseDTO {
    @JsonProperty("description")
    @NotBlank
    String description;
    @JsonProperty("tested")
    @NotNull
    Boolean tested;
    @JsonProperty("passed")
    @NotNull
    Boolean passed;
    @JsonProperty("number_of_tries")
    @NotNull
    @Min(1)
    int numberOfTries;
    @JsonProperty("last_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate lastUpdate;
}
