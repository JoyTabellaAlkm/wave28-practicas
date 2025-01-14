package com.example.testcase_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {
        private String description;
        private Boolean tested;
        private Boolean passed;
        @JsonProperty("number_of_tries")
        private Integer numberOfTries;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @JsonProperty("last_update")
        private LocalDate lastUpdate;
    }
