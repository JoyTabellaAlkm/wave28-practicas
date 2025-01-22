package com.example.Covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    private Long code;
    private String name;
    private Integer levelSeverity;
}
