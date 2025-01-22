package com.example.Covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SymptomDto {
    private Long code;
    private String name;
    private Integer levelServerity;
}
