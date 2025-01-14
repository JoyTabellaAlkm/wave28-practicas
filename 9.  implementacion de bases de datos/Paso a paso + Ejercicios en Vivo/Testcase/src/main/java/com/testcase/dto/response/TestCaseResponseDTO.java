package com.testcase.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseResponseDTO {
    Long id_case;
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;
    String last_update;
}