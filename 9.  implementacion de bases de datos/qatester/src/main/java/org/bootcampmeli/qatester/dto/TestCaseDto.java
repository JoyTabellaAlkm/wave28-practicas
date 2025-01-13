package org.bootcampmeli.qatester.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDto {

    private Long id;

    private String description;

    private boolean tested;

    private boolean passed;

    @JsonProperty("number_of_tries")
    private int numberOfTries;

    @JsonProperty("last_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;
}
