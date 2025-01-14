package com.example.qa_tester.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCaseDto {
    private Long id;
    private String descripcion;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getTested() {
        return tested;
    }

    public Boolean getPassed() {
        return passed;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }
}
