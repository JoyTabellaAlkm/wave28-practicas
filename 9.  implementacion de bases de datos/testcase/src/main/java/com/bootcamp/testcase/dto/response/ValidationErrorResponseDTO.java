package com.bootcamp.testcase.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorResponseDTO {
    private int status;
    private String message;
    private Map<String, String> errors;
}
