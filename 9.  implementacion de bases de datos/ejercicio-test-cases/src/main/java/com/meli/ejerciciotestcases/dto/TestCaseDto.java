package com.meli.ejerciciotestcases.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseDto {

    private String description;

    private Boolean tested;

    private Boolean passed;

    private int numberOfTries;

    private LocalDate lastUpdate;

    public TestCaseDto() {
    }

    @Override
    public String toString() {
        return "TestCaseDto{" +
                ", description='" + description + '\'' +
                ", tested=" + tested +
                ", passed=" + passed +
                ", numberOfTries=" + numberOfTries +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
