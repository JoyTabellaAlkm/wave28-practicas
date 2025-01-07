package com.mercadolibre.sprint1.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateExceptionDto {
    private int status;
    private List<Map<String, String>> errors;
}
