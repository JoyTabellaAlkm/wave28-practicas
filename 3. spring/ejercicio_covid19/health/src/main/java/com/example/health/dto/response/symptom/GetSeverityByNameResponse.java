package com.example.health.dto.response.symptom;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetSeverityByNameResponse {
    private String severity;
}
