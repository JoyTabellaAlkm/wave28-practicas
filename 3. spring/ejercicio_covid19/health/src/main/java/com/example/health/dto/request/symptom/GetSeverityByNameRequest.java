package com.example.health.dto.request.symptom;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetSeverityByNameRequest {
    private String name;
}
