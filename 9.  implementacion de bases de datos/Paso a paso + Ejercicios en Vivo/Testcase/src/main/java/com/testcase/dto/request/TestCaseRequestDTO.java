package com.testcase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseRequestDTO {
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;
    String last_update;
}