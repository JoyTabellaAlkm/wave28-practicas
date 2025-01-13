package com.bootcamp.testcase.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDTO {
    @JsonProperty("id_case")
    Long idCase;
    @JsonProperty("description")
    String description;
    @JsonProperty("tested")
    Boolean tested;
    @JsonProperty("passed")
    Boolean passed;
    @JsonProperty("number_of_tries")
    int numberOfTries;
    @JsonProperty("last_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate lastUpdate;
}
